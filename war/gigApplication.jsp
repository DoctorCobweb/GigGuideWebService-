<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="au.com.spinninghalf.gae.jaxrs.test.model.Gig" %>
<%@ page import="au.com.spinninghalf.gae.jaxrs.test.dao.Dao" %>

<!DOCTYPE html>


<%@page import="java.util.ArrayList"%>

<html>
  <head>
    <title>Gig Guide Form</title>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
      <meta charset="utf-8"> 
  </head>
  <body>
<%
Dao dao = Dao.INSTANCE;

UserService userService = UserServiceFactory.getUserService();
User user = userService.getCurrentUser();

String url = userService.createLoginURL(request.getRequestURI());
String urlLinktext = "Login";
List<Gig> gigs = new ArrayList<Gig>();
            
if (user != null){
    url = userService.createLogoutURL(request.getRequestURI());
    urlLinktext = "Logout";
    gigs = dao.getGigs(user.getUserId());
}
    
%>
  <div style="width: 100%;">
    <div class="line"></div>
    <div class="topLine">
      <div style="float: left;"><img src="images/drum.png" /></div>
      <div style="float: left;" class="headline">Spinning Half Gig Guide Database</div>
      <div style="float: right;"><a href="<%=url%>"><%=urlLinktext%></a> <%=(user==null? "" : user.getNickname())%></div>
    </div>
  </div>
<hr/>
<div style="clear: both;"/>  
You have a total number of <%= gigs.size() %>  gigs.
<hr/>
<form name="displayGig" method="post" action="rest/done">
	<table>
	  <tr>
	      <th>Date</th>
	      <th>Gig</th>
	      <th>Venue </th>
	      <th>Description</th>
	      <th>Tix URL</th>
	      <th>Price</th>
	      <th>Done </th>
	    </tr>
	
	<% for (Gig gig : gigs) {%>
		<tr> 
		<td>
			<%=gig.getDate()%>
		</td>
		<td>
			<%=gig.getShow()%>
		</td>
		<td>
			<%=gig.getVenue()%>
		</td>
		<td>
			<%=gig.getDescription()%>
		</td>
		<td>
			<%=gig.getTixUrl()%>
		</td>
		<td>
			<%=gig.getPrice()%>
		</td>
		<td>
			<input type="radio" value="<%=gig.getId()%>" name="deleteGig"/>
		</td>
		</tr>
	<%}
	%>
	<tr>
		<td colspan="6" align="right">
			<input type="submit" value="Delete" />
		</td>
		</tr> 
	</table>
</form>


<hr/>

<div class="main">

<div class="headline">New gig</div>

<% if (user != null){ %> 

<form action="/rest/new" method="post" accept-charset="utf-8">
  <table>
    <tr>
      <td><label for="date">Date</label></td>
      <td><input type="text" name="date" id="date" size="65"/></td>
    </tr>
    <tr>
      <td><label for="show">Gig: Headline Act</label></td>
      <td><input type="text" name="show" id="show" size="65"/></td>
    </tr>
    <tr>
      <td><label for="venue">Venue</label></td>
      <td><input type="text" name="venue" id="venue" size="65"/></td>
    </tr>
    <tr>
      <td valign="description"><label for="description">Description</label></td>
      <td><textarea rows="4" cols="50" name="description" id="description"></textarea></td>
    </tr>
    <tr>
      <td valign="top"><label for="tixUrl">Tix URL</label></td>
      <td><input type="url" name="tixUrl" id="tixUrl" size="65" /></td>
    </tr>
    <tr>
      <td><label for="price">Price</label></td>
      <td><input type="text" name="price" id="price" size="65"/></td>
    </tr>
    <tr>
      <td colspan="2" align="right">
      <input type="submit" value="Create"/>
      </td>
    </tr>
  </table>
</form>

<% }else{ %>

Please login with your Google account

<% } %>
</div>
</body>
</html> 