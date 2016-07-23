<?php
error_reporting(0);
session_start();
include("db.php");
$uname=$_POST['fname'];

$email=$_POST['email'];
$message=$_POST['message'];

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
$query="insert into contact(fname,email,message) values('".$uname."','".$email."','".$message."')";
$row=mysql_query($query);
$row=array();
$row['status']="success";
$row['sid']=SID;
$output[]=$row;

}
print(json_encode($output));
?>