<?php
$host = "localhost";
$dbname = "taskcompanion";
$user = "root";
$pass = "";

$pdo = new PDO("mysql:host=$host;dbname=$dbname;charset=utf8", $user, $pass);
$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

header("Content-Type: application/json");
header("Access-Control-Allow-Origin: *");
?>
