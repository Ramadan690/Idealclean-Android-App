

<?php
 $user = $_GET['user'];
 //$usertype = $_GET['usertype'];

  // Create connection
  $con=mysqli_connect("localhost","root","","");

  // Check connection
 if (mysqli_connect_errno())
 {
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
 }
 
 
 //$sql = "SELECT transactions FROM loginregister where user='$user'";

 $sql = "SELECT transactions FROM loginregister;

  if ($result = mysqli_query($con, $sql))
   {
	   //echo "Retrieving historical transactions";
   $resultArray = array();
   $tempArray = array();

   while($row = $result->fetch_object())
   {
   // Add each result into the results array
   $tempArray = $row;
   array_push($resultArray, $tempArray);
   }
   echo json_encode($resultArray);
   }
   // Close connections
   mysqli_close($con);

?>