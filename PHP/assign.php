<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['fullname']) && isset($_POST['email']) && isset($_POST['username'])) {
    if ($db->dbConnect()) {
        if ($db->Assign("booking", $_POST['fullname'], $_POST['email'], $_POST['username'])){
            echo $_POST['username']." cleaner assigned";
        } else echo $_POST['username']." could not update";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>
