<?php
require "DataBaseConfig.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }






    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }











    function logIn($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && password_verify($password, $dbpassword)) {
                $login = true;
            } 
            else $login = false; } 
        else $login = false;
        return $login;}



function logIncleaner($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username = '" . $username . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && password_verify($password, $dbpassword)) {
                $login = true;
            } 
            else $login = false; } 
        else $login = false;
        return $login;}




 function logInAdmin($table, $username, $password)
    {
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $this->sql = "select * from " . $table . " where username ='Maxamed'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbusername = $row['username'];
            $dbpassword = $row['password'];
            if ($dbusername == $username && password_verify($password, $dbpassword)) {
                $login = true;
            } 
            else $login = false; } 
        else $login = false;
        return $login;}








    function signUp($table, $fullname, $email, $username, $password)
    {
        $fullname = $this->prepareData($fullname);
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $email = $this->prepareData($email);
        $password = password_hash($password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $table . " (fullname, username, password, email) VALUES ('" . $fullname . "','" . $username . "','" . $password . "','" . $email . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
	
	




    function signUpCleaner($table, $fullname, $email, $username, $password)
    {
        $fullname = $this->prepareData($fullname);
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $email = $this->prepareData($email);
        $password = password_hash($password, PASSWORD_DEFAULT);
        $this->sql =
            "INSERT INTO " . $table . " (fullname, username, password, email) VALUES ('" . $fullname . "','" . $username . "','" . $password . "','" . $email . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
    








    function Approve($table, $username)
    {
        $username = $this->prepareData($username);

        $this->sql =
            "UPDATE " . $table . " SET status = 'Approved' WHERE ID = '".$username ."'";

        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }





    function payment($table, $username)
    {
        $username = $this->prepareData($username);

        $this->sql =
            "UPDATE " . $table . " SET payment = 'Paid' WHERE ID = '".$username ."'";

        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }




    function Update($table, $fullname, $email, $username, $password)
    {
        $fullname = $this->prepareData($fullname);
        $username = $this->prepareData($username);
        $password = $this->prepareData($password);
        $email = $this->prepareData($email);
        $password = password_hash($password, PASSWORD_DEFAULT);


        $this->sql =
            "UPDATE " . $table . " SET fullname = '" . $fullname . "', username = '" . $username . "', password = '" . $password . "', email = '" . $email . "' WHERE username = '" . $username . "' or fullname = '" . $fullname . "' or username = '" . $username . "' or password = '" . $password . "' or email = '" . $email . "'";

        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }







function Assign($table, $fullname, $email, $username)
    {
        $fullname = $this->prepareData($fullname);
        $username = $this->prepareData($username);
        $email = $this->prepareData($email);


        $this->sql =
            "UPDATE " . $table . " SET CleanerName = '" . $email . "', CleanerTel = '" . $username . "' WHERE transaction_id = '".$fullname."'";

        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }





    function Delete($table, $fullname, $email, $username)
    {
        $fullname = $this->prepareData($fullname);
        $username = $this->prepareData($username);
        $email = $this->prepareData($email);


        $this->sql =
            "DELETE FROM " . $table . " WHERE fullname = '" . $fullname . "' or username = '" . $username . "' or email = '" . $email . "'";

        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }


	
	
	function booking($table, $user, $address, $crew, $hours, $addon, $date, $time, $total, $services,$id,$trans_id)
    {
        $user = $this->prepareData($user);
		$address = $this->prepareData($address);
        $crew = $this->prepareData($crew);
        $hours = $this->prepareData($hours);
        $addon = $this->prepareData($addon);
		$date = $this->prepareData($date);
		$time = $this->prepareData($time);
		$total = $this->prepareData($total);
		$services = $this->prepareData($services);

        $this->sql =
            "INSERT INTO " . $table . " (id,user, address, crew, hours, addon, date, time, total, services, transaction_id) VALUES ('" . $id . "','" . $user . "','" . $address . "','" . $crew . "','" . $hours . "','" . $addon . "','" . $date . "','" . $time . "','" . $total . "','" . $services . "','" . $trans_id . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
	
	








	
	function transactions($table, $user, $address,  $date,  $total,$id,$trans_id)
    {
        $user = $this->prepareData($user);
        
	   $address = $this->prepareData($address);
		
		$date = $this->prepareData($date);
		
		$total = $this->prepareData($total);
        
		
		          //  "INSERT INTO " . $table . " (user, crew, hours, addon, date, time, total) VALUES ('" . $user . "','" . $crew . "','" . $hours . "','" . $addon . "')";

		
        $this->sql =
            "INSERT INTO " . $table . " (ID,user, address, date,  total,Booking_id) VALUES ('" . $trans_id . "','" . $user . "','" . $address . "','" . $date . "','" . $total . "','" . $id . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }











	
	function contact($table, $user, $message)
    {
        $user = $this->prepareData($user);
        
	   $message = $this->prepareData($message);
		
        $this->sql =
            "INSERT INTO " . $table . " (user, message) VALUES ('" . $user . "','" . $message . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
	
	






	
	
	    function transhistory($table, $user)
    {
        $user = $this->prepareData($user);
        
        $this->sql = "select * from " . $table . " where user = '" . $user . "'";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            $dbuser = $row['user'];
            
            if ($dbuser == $user ) {
                $history = true;
				
				
				//halkaan
				
				$response = array();
				
				$sql_query = " select * from transactions";
				
				$result = mysqli_query($connect, $sql_query);
				
				if(mysqli_num_rows($result)>0){
					
					while($row = mysqli_fetch_assoc($result)){
						
						array_push($response, $row);
					}
				}
				
				else{
					
				$response ['success']=0;
				$response ['message']='No data';
				
				}
				
				json_encode($response);
				
				//halkaan
				
            } else $history = false;
        } else $history = false;

        return $history;
    }
	
	



	
	

}

?>
