<?php
require "db.php";

$data = json_decode(file_get_contents("php://input"));

$username = $data->username ?? "";
$email = $data->email ?? "";
$passwordPlain = $data->password ?? "";

if ($username === "" || $email === "" || $passwordPlain === "") {
    echo json_encode(["success" => false, "message" => "Missing fields"]);
    exit;
}

$password = password_hash($passwordPlain, PASSWORD_DEFAULT);

$stmt = $pdo->prepare("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
$stmt->execute([$username, $email, $password]);

echo json_encode(["success" => true, "message" => "User registered"]);
?>
