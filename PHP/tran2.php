<?php 

	$connection = mysqli_connect("localhost","root","","loginregister");
	
	$result = array();
	$result['data'] = array();
	$user = $_GET['user'];

	$sql= "SELECT T.id,B.user,B.address,B.date,B.total,status,payment,CleanerName,CleanerTel from transactions AS T JOIN booking AS B ON B.transaction_id = T.ID WHERE B.user = '$user' ";
	$responce = mysqli_query($connection,$sql) or die( mysqli_error($connection));;


	while($row = mysqli_fetch_array($responce))
		{
			$index['T.id']        =   $row['0'];
			$index['B.user']      = $row['1'];
			$index['B.address']   =   $row['2'];
			$index['B.date']      =   $row['3'];
			$index['B.total']     =   $row['4'];
			$index['status']     =   $row['5'];
			$index['payment']     =   $row['6'];
			$index['CleanerName']     =   $row['7'];
			$index['CleanerTel']     =   $row['8'];

		
			echo "<b>--> ID :</b> ".$index['T.id']." "."<b>NameCus : </b>".$index['B.user']." "."<b>Address : </b>".$index['B.address']." "."<b>Date : </b>".$index['B.date']." "."<b>Fees : </b>".$index['B.total']." <b>status : </b>".$index['status']." "."<b>Fees : </b>  <span style='color:red'>".$index['payment']."</span> "."<br><br>CleanerName : ".$index['CleanerName']." <br>CleanerTel : ".$index['CleanerTel']."<br><br>------------------------------------------<br>";
		}
			
			


			mysqli_close($connection);

 ?>