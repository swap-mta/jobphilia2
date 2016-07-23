<?php
include("db.php");
$catagory=$_POST['catagory'];
$id=$_POST['id'];
$query="select * from catagory1  where catagory='".$catagory."'and id='".$id."'";
$result=mysql_query($query);
while($row=mysql_fetch_assoc($result))
{
$output[]=$row;
}
print(json_encode($output));
?>