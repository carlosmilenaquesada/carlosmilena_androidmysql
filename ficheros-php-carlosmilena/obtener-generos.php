<?php
include 'conexion.php';
$result = array();
$result['generos'] = array();
$query = "SELECT nombregenero FROM carlosmilena_generos ORDER BY nombregenero";
$responce = mysqli_query($conexion, $query);
while ($row = mysqli_fetch_array($responce)) {
    $index['nombregenero'] = $row['0'];
    array_push($result['generos'], $index);
}
$result["exito"] = "1";
echo json_encode($result);

?>