<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
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
</body>

<script type="text/javascript">
	function goHome(){
		window.location.replace("Home.jsp");
	}
</script>

</html>