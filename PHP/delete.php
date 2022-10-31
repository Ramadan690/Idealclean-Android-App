<?php
require "DataBase.php";
$db = new DataBase();
    if ($db->dbConnect()) {
        if ($db->Delete("customers", $_POST['fullname'], $_POST['email'], $_POST['username'])) {
            echo " User deleted deleted";
        } else echo $_POST['username']." could not be deleted";
    } else echo "Error: Database connection";

?>
