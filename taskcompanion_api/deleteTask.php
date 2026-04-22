<?php
require "db.php";

$data = json_decode(file_get_contents("php://input"));

$stmt = $pdo->prepare("DELETE FROM tasks WHERE task_id = ?");
$stmt->execute([$data->task_id]);

echo json_encode(["success" => true, "message" => "Task deleted"]);
?>
