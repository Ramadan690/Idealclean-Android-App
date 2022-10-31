<?php
require "DataBase.php";
$db = new DataBase();


$id = rand(0,999);
$trans_id = rand(0,999);

if (isset($_POST['user']) && isset($_POST['address']) && isset($_POST['crew']) && isset($_POST['hours']) && isset($_POST['addon'])&& isset($_POST['date']) && isset($_POST['time']) && isset($_POST['total']) && isset($_POST['services'])) {




    if ($db->dbConnect()) {
       


	   if ($db->booking("booking",$_POST['user'],$_POST['address'], $_POST['crew'], $_POST['hours'], $_POST['addon'], $_POST['date'], $_POST['time'], $_POST['total'], $_POST['services'],$id,$trans_id)) {
		   
		    if ($db->transactions("transactions", $_POST['user'],$_POST['address'],  $_POST['date'], $_POST['total'],$id,$trans_id)){
		
		   
            echo "Booking Successful";
        
}

        } else echo "Booking Failed";
    




    } else echo "Error: Database connection";







}else echo "All fields are required";

?>
