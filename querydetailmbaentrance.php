<?php
include("db.php");
$query="select * from querydetailmbaentrance";
$result=mysql_query($query);
while($row=mysql_fetch_assoc($result))
{
$output[]=$row;
}
print(json_encode($output));
?>