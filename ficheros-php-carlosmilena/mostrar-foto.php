<?php
include 'conexion.php';
$idimagen = $_POST['idimagen'];
$result = array();
$result['imagenes'] = array();
$query = "SELECT * FROM carlosmilena_imagenes WHERE idimagen = '$idimagen' ";
$response = mysqli_query($conexion, $query);
while ($row = mysqli_fetch_array($response)) {
    $index['idimagen'] = $row['0'];
    $index['imagen'] = $row['1'];
    array_push($result['imagenes'], $index);
}
$result["exito"] = "1";
echo json_encode($result);
?>