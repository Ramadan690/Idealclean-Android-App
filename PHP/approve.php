<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['username'])) {
    if ($db->dbConnect()) {
        if ($db->Approve("transactions", $_POST['username'])) {
            echo $_POST['username']." The transaction has been approved";
        } else echo $_POST['username']." could not update";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>