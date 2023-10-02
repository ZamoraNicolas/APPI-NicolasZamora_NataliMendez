<?php

include 'Conexion.php';

$ID = $_GET['ID'];

$Consulta = "SELECT * FROM calculos WHERE ID = '$ID'";
    

$resultado = $Conexion -> query($Consulta);

while($fila = $resultado -> fetch_array()){
    $usuario = array(array_map('utf8_encode',$fila)); 
}

echo json_encode($usuario);
$resultado->close();

?>