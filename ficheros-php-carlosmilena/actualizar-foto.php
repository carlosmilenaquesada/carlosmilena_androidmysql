<?php
include 'conexion.php';
$idProducto = $_POST['idimagen'];
$foto = $_POST['imagen'];
$query = "UPDATE carlosmilena_imagenes SET imagen ='$imagen' WHERE idProducto = '$idimagen'";
$resultado = mysqli_query($conexion, $query);
if ($resultado) {
    echo "datos actualizados";
} else {
    echo "error en actualizacion";
}
mysqli_close($conexion);
?>