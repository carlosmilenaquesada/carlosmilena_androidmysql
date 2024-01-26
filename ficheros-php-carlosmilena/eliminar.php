<?php
include 'conexion.php';
$identificador = $_POST["identificador"];
$query = "DELETE FROM carlosmilena_juegos WHERE identificador = '$identificador'";
$result = mysqli_query($conexion, $query);
if ($result) {
    echo "datos eliminados";
} else {
    echo "error";
}
mysqli_close($conexion);
?>