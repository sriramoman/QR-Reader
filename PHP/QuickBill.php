<?php
$query  = explode('&', $_SERVER['QUERY_STRING']);
$params = array();
$serverName = 'localhost';
$userName = 'root';
$password = 'bugsy';
$dbName = 'QUICKBILL';
$productTable = "product";
$orderTable = "orders";
$con = mysql_connect($serverName,$userName,$password);
if(isset($query))
{

	if (!$con) {
    		die("Connection failed: " . mysql_connect_error());
	}
	mysql_select_db($dbName);
	foreach($query as $param)
	{
		list($name, $value) = explode('=', $param, 2);
		$params[urldecode($name)][] = urldecode($value);
	}
	$barCodes = $params['barcode'];
	$date = date('Y-m-d H:i:s');
	$selectQuery = 'select max(transactionid) as transid from '."$orderTable".';';
	$result = mysql_query($selectQuery);
	while($row = mysql_fetch_array($result, MYSQL_ASSOC))
		$transId = $row['transid']+1;
	$concatenatedBarCodes = '';
	foreach($barCodes as $barCode)
	{
		$insertStatement = 'insert into '."$orderTable".' values('."$transId".',"'."$barCode".'","'."$date".'");';
		mysql_query($insertStatement,$con);
		$concatenatedBarCodes = $concatenatedBarCodes.'"'.$barCode.'",';
	}
	$concatenatedBarCodes = substr($concatenatedBarCodes,0,-1);
	$productQuery = 'select barcode,description,price from '."$productTable".' where barcode in ('.$concatenatedBarCodes.');';
	$result = mysql_query($productQuery);
	$productDataStructure = array();

	if($result)
	{
		while($row = mysql_fetch_array($result,MYSQL_ASSOC))
		{
			$productValues = array($row['description'],$row['price']);
			$productDataStructure[$row['barcode']]= $productValues;
		}
			
	}
	echo $transId.", Walmart,".date('m-d-y')."\n";
	foreach($barCodes as $barCode)
	{
		echo $productDataStructure[$barCode][0].",".$productDataStructure[$barCode][1]."\n";
	}
	#echo '</body></html>'	 
	#echo var_dump($productDataStructure);	
}
mysql_close($conn);
?>
