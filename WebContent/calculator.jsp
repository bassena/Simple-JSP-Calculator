<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="control.DoCalc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accountant Calculator</title>
<link rel="stylesheet" type="text/css" href="calculator.css"/>

<script type="text/javascript">
	var $ = function(id){
		return document.getElementById(id);
	}
	
	function changePositivity(val){
		if(!isNaN(val)){
			$('numbers').value = val * -1;
		}
	}
</script>
</head>
<body>
	<div id="paperTrail"name="trail">
	
	<%=(request.getParameter("trail") == null ? 0.0 : request.getParameter("trail")) %>

	</div>
	
	<div id="calculator">
	<form method="get" action="docalc">
	<input type="text" name="numbers" id="numbers" size="41" readonly/>
		<div id="numPad">
			<input type="button" id="7" value="7" onclick="$('numbers').value += 7"/>
			<input type="button" id="8" value="8" onclick="$('numbers').value += 8"/>
			<input type="button" id="9" value="9" onclick="$('numbers').value += 9"/>
			<br/>
			<input type="button" id="4" value="4" onclick="$('numbers').value += 4"/>
			<input type="button" id="5" value="5" onclick="$('numbers').value += 5"/>
			<input type="button" id="6" value="6" onclick="$('numbers').value += 6"/>
			<br/>
			<input type="button" id="1" value="1" onclick="$('numbers').value += 1">
			<input type="button" id="2" value="2" onclick="$('numbers').value += 2"/>
			<input type="button" id="3" value="3" onclick="$('numbers').value += 3"/>
			<br/>
			<input type="button" id="0" value="0" onclick="$('numbers').value += 0"/>
			<input type="button" id="." value="." onclick="$('numbers').value += '.'"/>
		</div>
		
		<div id="operations">
			<input type="button" id="plus-minus" value="+/-" onclick="changePositivity($('numbers').value)"/>
			<button type="submit" name="operation" id="exp" value="xy">x<sup>y</sup></button><br/>
			<input type="submit" name="operation" id="plus" value="+"/>
			<input type="submit" name="operation" id="multiply" value="x"/><br/>
			<input type="submit" name="operation" id="minus" value="-"/>
			<input type="submit" name="operation" id="divide" value="/"/><br/>
			<button type="submit" name="operation" id="sqrt" value="sqrt of">&radic;</button>
			<button type="submit" name="operation" id="square" value="square of">x<sup>2</sup></button><br/>
			<input type="button" id="clearField" value="Clear" onclick="$('numbers').value = ''"/><br/>
			<input type="submit" name="operation" id="clearAll" value="Clear All" onclick="$('numbers').value = ''; $('paperTrail').innerHTML = '';"/>
						
		</div>
	</form>
	</div>
</body>
</html>