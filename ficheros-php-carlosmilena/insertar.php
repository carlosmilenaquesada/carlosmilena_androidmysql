<?php
include 'conexion.php';
$identificador = $_POST['identificador'];
$plataforma = $_POST['plataforma'];
$nombrejuego = $_POST['nombrejuego'];
$genero = $_POST['genero'];
$preciojuego = $_POST['preciojuego'];
$query = "INSERT INTO carlosmilena_juegos (identificador,plataforma,nombrejuego,genero,preciojuego) values ('$identificador' ,'$plataforma', '$nombrejuego', '$genero', '$preciojuego')";
try {
    $resultado = mysqli_query($conexion, $query) or throw new Exception(mysqli_error);
    echo "datos insertados";
} catch (exception $e) {
    echo $e->getMessage();
}
mysqli_close($conexion);
?>