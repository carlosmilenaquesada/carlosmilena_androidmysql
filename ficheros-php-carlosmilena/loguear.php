<?php
include 'conexion.php';
$email = $_POST['email'];
$password = $_POST['password'];
$result = array();
$result['usuarios'] = array();
$query = "SELECT * FROM carlosmilena_usuarios WHERE email = '$email' AND password = '$password' ";
$response = mysqli_query($conexion, $query);
if ($row = mysqli_fetch_array($response)) {
    echo "autenticacion ok";
}
?>