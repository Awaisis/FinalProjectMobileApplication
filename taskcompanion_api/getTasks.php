<?php
require "db.php";

$user_id = $_GET["user_id"] ?? null;

if ($user_id === null) {
    echo json_encode([]);
    exit;
}

$stmt = $pdo->prepare("SELECT * FROM tasks WHERE user_id = ?");
$stmt->execute([$user_id]);

echo json_encode($stmt->fetchAll(PDO::FETCH_ASSOC));
?>
