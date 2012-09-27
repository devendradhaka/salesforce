<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REQUESTER PAGE</title>
<script type="text/javascript">
 <%-- function validateAndPrint() {

	 var text=document.forms["request"]["myText"].value;
	 var responseDiv = document.getElementById("response");
	 if(text == null || text == "") {
		 responseDiv.innerHTML = "Text box is Empty.. Plz type the request string!!!";
		 return false;
	 } 
	 else{
		 var abcd = '<%=request.getAttribute("respmsg")%>'
	responseDiv.innerHTML = abcd;
//	responseDiv.innerHTML = respmsg;	 
	return true;
	 }
 } --%>
</script>
</head>
<body>
<h1>Enter the word for synonym and press Submit</h1>
<div style="width:250px;height: 100px; top: 100px; left:100px; background: aqua;">
<form name="request" action="DictionaryServlet" method="get">
	My Text :: <input type="text" name="txtweb-message" id = "textBox"></input>
	<input type="submit" value = "Submit"></input>
</form>
</div> 
<div style="background: gray;" id = "response"></div>
</body>
</html>