<?php
include 'conexion.php';
$email = $_POST['email'];
$password = $_POST['password'];
$query = "INSERT INTO carlosmilena_usuarios (email,password) values ('$email' ,'$password') ";
try {
    $resultado = mysqli_query($conexion, $query) or throw new Exception(mysqli_error);
    echo "registro ok";
} catch (exception $e) {
    echo $e->getMessage();
}
mysqli_close($conexion);
?>