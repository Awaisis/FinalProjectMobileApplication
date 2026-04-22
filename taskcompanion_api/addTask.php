<?php
require "db.php";

$data = json_decode(file_get_contents("php://input"));

$stmt = $pdo->prepare("INSERT INTO tasks (user_id, title, description, due_date, is_completed)
                       VALUES (?, ?, ?, ?, ?)");
$stmt->execute([
    $data->user_id,
    $data->title,
    $data->description,
    $data->due_date,
    $data->is_completed ? 1 : 0
]);

echo json_encode(["success" => true, "message" => "Task added"]);
?>
