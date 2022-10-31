<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['username'])) {
    if ($db->dbConnect()) {
        if ($db->payment("transactions", $_POST['username'])) {
            echo $_POST['username']." The transaction has been paid";
        } else echo $_POST['username']." could not update";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>