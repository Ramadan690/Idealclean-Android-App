<?php 

	$connection = mysqli_connect("localhost","root","","loginregister");
	
	$result = array();
	$result['data'] = array();

	$sql= "SELECT id,user,message from contact ";
	$responce = mysqli_query($connection,$sql) or die( mysqli_error($connection));;


	while($row = mysqli_fetch_array($responce))
		{
			$index['id']        =   $row['0'];
			$index['user']      = $row['1'];
			$index['message']   =   $row['2'];


		
			echo "<b>--> ID :</b> ".$index['id']." "."<b>User : </b>".$index['user']." "."<b>Message : </b>".$index['message']."<br><br>------------------------------------------<br>";
		}
			
			


			mysqli_close($connection);

 ?>