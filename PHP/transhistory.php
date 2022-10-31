<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['user'])) {
    if ($db->dbConnect()) {
        if ($db->transhistory("transactions", $_POST['user'])) {
            echo "Transactions Found";
        } else echo "No transactions found";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>