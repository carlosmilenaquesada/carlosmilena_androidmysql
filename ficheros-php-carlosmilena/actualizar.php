<?php
include 'conexion.php';
$identificador_old = $_POST['identificador_old'];
$identificador_new = $_POST['identificador_new'];
$plataforma = $_POST['plataforma'];
$nombrejuego = $_POST['nombrejuego'];
$genero = $_POST['genero'];
$preciojuego = $_POST['preciojuego'];
$query = "UPDATE carlosmilena_juegos SET identificador ='$identificador_new',plataforma ='$plataforma', nombrejuego ='$nombrejuego', genero ='$genero', preciojuego ='$preciojuego' WHERE identificador = '$identificador_old'";
try {
    mysqli_query($conexion, $query) or throw new Exception(mysqli_error);
    echo "datos actualizados";
} catch (exception $e) {
    echo $e->getMessage();
}
mysqli_close($conexion);
?>