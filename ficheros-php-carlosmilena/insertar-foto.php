<?php
include 'conexion.php';
$idimagen = $_POST['idimagen'];
$imagen = $_POST['imagen'];
$query = "INSERT INTO carlosmilena_imagenes (idimagen,imagen) values ('$idimagen' ,'$imagen') ";
$resultado = mysqli_query($conexion, $query);
if ($resultado) {
    echo "foto insertada";
} else {
    echo "datos error";
}
mysqli_close($conexion);
?>