<?php
error_reporting(0);
session_start();
include("db.php");
$uname=$_POST['uname'];
$password=$_POST['password'];
$contact=$_POST['contact'];
$email=$_POST['email'];
$pin=$_POST['pin'];

$query="select * from users where email='".$email."'";
$row=mysql_query($query);
$count=mysql_num_rows($row);
if($count>0)
{
$row=array();
$row['status']="fail";
$row['sid']=SID;
$output[]=$row;
}
else
{
$query="insert into users(full_name,user_pass,email,contact,pin_code,date_joined) values('".$uname."','".$password."','".$email."','".$contact."','".$pin."',now())";
$row=mysql_query($query);
$row=array();
$row['status']="success";
$row['sid']=SID;
$output[]=$row;

}
print(json_encode($output));
?>