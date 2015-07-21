<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Details Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top topnav"
		role="navigation">
		<div class="topnav" style="backgroud-color: #888888;">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1" style="margin-left: 50px;">
				<ul class="nav navbar-nav">
					<li><a href="#" onclick="goHome();return false;"><i
							class="glyphicon glyphicon-home"></i> Home</a></li>

					<!-- <li><a href="#/document"><i
							class="glyphicon glyphicon-envelope"></i> Details</a></li> -->
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li style="margin-top: 15px; margin-right: 90px; color: #500000;">Welcome
						to my Demo Project</li>
				</ul>
			</div>
		</div>
	</nav>




	<form name="actionForm" data-toggle="validator" action="HomeServlet"
		method="POST">

		<br> <br> <br> <br> <br>
		<div class="col-md-10 col-md-offset-1">

			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Review Details</h3>
				</div>

				<div class="panel-body">
					<table class="table table-hover table-striped">
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Gender</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${userData}">
								<tr>
									<td>${user.firstName}</td>
									<td>${user.lastName}</td>
									<td>${user.email}</td>
									<td><c:if test="${user.gender == 'M'}">
											Male
											</c:if> <c:if test="${user.gender == 'F'}">
											Female
											</c:if></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>

		</div>
	</form>

	<nav class="navbar navbar-default navbar-fixed-bottom topnav"
		role="navigation">
		<div class="container topnav"
			style="font-size: small; color: #500000; text-align: center;">
			<BR>
			<p>
				<b>WARNING:</b> ALL RIGHTS ARE RESERVED @MohdBasheikh @2015.
			</p>
		</div>
	</nav>

</body>

<script type="text/javascript">
	function goHome(){
		window.location.replace("Home.jsp");
	}
</script>
</html>