<?php 

	$connection = mysqli_connect("localhost","root","","loginregister");
	
	$result = array();
		$user = $_GET['user'];

	$result['data'] = array();
	$select= "SELECT T.id,B.user,B.address,B.date,B.total,status,payment,CleanerName,CleanerTel,hours,addon,`time` from transactions AS T JOIN booking AS B ON B.transaction_id = T.ID WHERE CleanerName = '$user'";
	$responce = mysqli_query($connection,$select) or die( mysqli_error($connection));
	
	while($row = mysqli_fetch_array($responce))
		{


		    $index['B.id']        =   $row['0'];
			$index['B.user']      = $row['1'];
			$index['B.address']   =   $row['2'];
			$index['B.date']      =   $row['3'];
			$index['B.total']     =   $row['4'];
			$index['status']     =   $row['5'];
			$index['payment']     =   $row['6'];
			$index['CleanerName']     =   $row['7'];
			$index['CleanerTel']     =   $row['8'];

			
			$index['hours']      =   $row['9'];
			$index['addon']      =   $row['10'];
			$index['time']      =   $row['11'];
		




echo "<b>--> ID :</b> ".$index['B.id']." "."<b>NameCus : </b>".$index['B.user']." "."<b>Address : </b>".$index['B.address']." "."<b>Date : </b>".$index['B.date']." "."<b>Fees : </b>".$index['B.total']." <b>status : </b>".$index['status']." "."<b>Fees : </b>  <span style='color:red'>".$index['payment']."</span> "." <b>Service : </b>".$index['hours']." "." <b>addon : </b>".$index['addon']." "." <b>time : </b>".$index['time']." ";

echo "<br><br>CleanerName : ".$index['CleanerName']." <br>CleanerTel : ".$index['CleanerTel']."<br><br>------------------------------------------<br>";

		}
			




			mysqli_close($connection);

 ?>