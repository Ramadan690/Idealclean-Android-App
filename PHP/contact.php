<?php
require "DataBase.php";
$db = new DataBase();


  //if (isset($_POST['user']) && isset($_POST['crew']) && isset($_POST['hours']) && isset($_POST['addon'])) {

if (isset($_POST['user']) && isset($_POST['message'])) {
    if ($db->dbConnect()) {
       

     
	   if ($db->contact("contact", $_POST['user'],$_POST['message'])) {
		   
		   //halkaan
		   
		  //  if ($db->transactions("transactions", $_POST['user'],$_POST['address'],  $_POST['date'], $_POST['total']))
		   
		   //halkaan
		   
            echo "Message sent Successfully";
        } else echo "Message Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>
