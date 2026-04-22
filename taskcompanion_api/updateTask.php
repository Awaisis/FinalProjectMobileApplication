<?php
require "db.php";

$data = json_decode(file_get_contents("php://input"));

$stmt = $pdo->prepare("UPDATE tasks 
                       SET title = ?, description = ?, due_date = ?, is_completed = ?
                       WHERE task_id = ?");
$stmt->execute([
    $data->title,
    $data->description,
    $data->due_date,
    $data->is_completed ? 1 : 0,
    $data->task_id
]);

echo json_encode(["success" => true, "message" => "Task updated"]);
?>
