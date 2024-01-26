<?php
include 'conexion.php';
$result = array();
$result['consolas'] = array();
$query = "SELECT nombreconsola FROM carlosmilena_consolas ORDER BY nombreconsola";
$responce = mysqli_query($conexion, $query);
while ($row = mysqli_fetch_array($responce)) {
    $index['nombreconsola'] = $row['0'];
    array_push($result['consolas'], $index);
}
$result["exito"] = "1";
echo json_encode($result);
?>