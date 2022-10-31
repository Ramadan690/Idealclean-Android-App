<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['fullname']) && isset($_POST['email']) && isset($_POST['username']) && isset($_POST['password'])) {
    if ($db->dbConnect()) {
        if ($db->Update("customers", $_POST['fullname'], $_POST['email'], $_POST['username'], $_POST['password'])) {
            echo $_POST['username']." account has been updated";
        } else echo $_POST['username']." could not update";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>
