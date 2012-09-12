<% 
String userAgent = (String) request.getHeader("user-agent"); 
String hostName = (String) request.getHeader("Host");
String acceptType = (String) request.getHeader("Accept");
String connection = (String) request.getHeader("Connection");
String connectionTimeOut = (String) request.getHeader("Keep-Alive");
String charSet = (String) request.getHeader("Accept-Charset");
%>
<HTML>
  <HEAD>
    <TITLE>JSP Scriptlet Example</TITLE>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
  </HEAD>
<BODY>
<jsp:scriptlet>
if (userAgent.indexOf("MSIE") != -1) 
{ 
</jsp:scriptlet> 
<p>You are using Internet Microsoft Explorer.</p>
<jsp:scriptlet>
} 
else 
{
</jsp:scriptlet>
<p>You are not using Internet Microsoft Explorer. You are using <%= userAgent %> </p>
<p>You are <%= hostName %></p>
<p>You, the client, accept the following MIME types: <%= acceptType %></p>
<p>The connection timeout is <%= connectionTimeOut %></p>
<p>The connection type is <%= connection %></p>
<p>The charSet accept type is <%= charSet %></p>
<jsp:scriptlet>
} 
</jsp:scriptlet>
<% out.println("Example of out implcicit object"); %> 
<% String userName = (String) session.getAttribute("username");
   out.println(userName);
%>

<%
    java.util.Enumeration names = request.getHeaderNames();
    while (names.hasMoreElements()) {
    	String name = (String) names.nextElement();
    	%>
    	<p>
    	<%
    	out.println(name + ": " + request.getHeader(name) + "\n");
    	%>
    	</p>
    	<%
    }
%>

<form>
First name: <input type="text" /><br/>
Last name: <input type="text" /><br/>
Password: <input type="password" name="pwd" />
<br/>

<input type="radio" name="sex" value="male" />Male<br/>
<input type="radio" name="sex" value="female" />Female<br/>

<input type="checkbox" name="vehicle" value="Bike" /> I have a Bike<br/>
<input type="checkbox" name="vehicle" value="Car" />I have a Car<br/>

</form>

<form name="input" action="copyleft1.jsp" method="get">
  Username: <input type="text" name="user_dude" />
  <input type="submit" value="Submit" />
</form>




</BODY>
</HTML>