<?php 

	$connection = mysqli_connect("localhost","root","","loginregister");
	
	$result = array();
	$result['data'] = array();
	$select= "SELECT * from customers";
	$responce = mysqli_query($connection,$select);
		echo "----------------------<h5>Customers informations</h5>-----------------------<Br>";

	while($row = mysqli_fetch_array($responce))
		{
			$index['id']         =   $row['0'];
			$index['fullname']   = 	$row['1'];
			$index['username']   =   $row['2'];
			$index['email']      =   $row['4'];
			

echo "<b>--> ID :</b> ".$index['id']." "."<b>Fullname : </b>".$index['fullname']." "."<b>Username : </b>".$index['username']." "."<b>Email : </b>".$index['email']." "."<br><br>------------------------------------------<br>";


		}
			
			
			mysqli_close($connection);

 ?>