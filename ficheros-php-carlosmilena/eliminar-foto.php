<?php
include 'conexion.php';
$idimagen = $_POST["idimagen"];
$query = "DELETE FROM carlosmilena_imagenes WHERE idimagen = '$idimagen'";
$result = mysqli_query($conexion, $query);
if ($result) {
    echo "datos eliminados";
} else {
    echo "error";
}
mysqli_close($conexion);
?>