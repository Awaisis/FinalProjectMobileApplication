<?php
require "db.php";

$data = json_decode(file_get_contents("php://input"));

$email = $data->email ?? "";
$password = $data->password ?? "";

$stmt = $pdo->prepare("SELECT * FROM users WHERE email = ?");
$stmt->execute([$email]);
$user = $stmt->fetch(PDO::FETCH_ASSOC);

if ($user && password_verify($password, $user["password"])) {
    echo json_encode([
        "success" => true,
        "user_id" => $user["user_id"],
        "username" => $user["username"],
        "email" => $user["email"]
    ]);
} else {
    echo json_encode(["success" => false, "message" => "Invalid credentials"]);
}
?>
