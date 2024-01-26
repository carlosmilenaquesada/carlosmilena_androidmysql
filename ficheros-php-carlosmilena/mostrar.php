<?php
include 'conexion.php';
$result = array();
$result['tablajuego'] = array();
$query = "SELECT * FROM carlosmilena_juegos ORDER BY CONVERT(identificador, SIGNED);";
$responce = mysqli_query($conexion, $query);
while ($row = mysqli_fetch_array($responce)) {
    $index['identificador'] = $row['0'];
    $index['plataforma'] = $row['1'];
    $index['nombrejuego'] = $row['2'];
    $index['genero'] = $row['3'];
    $index['preciojuego'] = $row['4'];
    array_push($result['tablajuego'], $index);
}
$result["exito"] = "1";
echo json_encode($result);
?>