<?php
include("db.php");
$catagory=$_POST['uname'];
$query="select * from freshers  where catagory='".$catagory."'";
$result=mysql_query($query);
while($row=mysql_fetch_assoc($result))
{
$output[]=$row;
}
print(json_encode($output));
?>