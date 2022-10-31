<?php

$host = 'localhost';
$userdb='root';
$pwd='';
$db='loginregister';


$conn = mysqli_connect($host,$userdb,$pwd,$db);

if(!conn){
	
	die("Error in connection: ". mysqli_connect_error());
}




//halkaan
				
				$response = array();
				
				$sql_query = " select * from transactions";
				
				$result = mysqli_query($conn, $sql_query);
				
				if(mysqli_num_rows($result)>0){
					
					while($row = mysqli_fetch_assoc($result)){
						
						$index['id']      = $row['0'];
						$index['user']    = $row['1'];
						$index['address']   = $row['2'];
						$index['date'] = $row['3'];
						$index['total'] = $row['4'];
						
						array_push($response, $row,$index);
					}
				}
				
				else{
					
				$response['success']=0;
				$response['message'] = 'No data';
				
				}
				
				echo json_encode($response, JSON_PRETTY_PRINT);
				
				mysqli_close;
				
				?>
				
				