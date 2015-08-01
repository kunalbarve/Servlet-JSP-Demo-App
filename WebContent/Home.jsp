<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>HomePage</title>
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

	<jsp:include page="header.jsp" />
	
	<form name="actionForm" data-toggle="validator" action="HomeServlet"
		method="POST">
		<input type="hidden" name="mode" value="saveData" /> <br> <br>
		<br> <br> <br>
		<div class="col-md-10 col-md-offset-1">

			<div class="login-panel panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Enter Your Details</h3>
				</div>

				<div class="panel-body">
					<div class="form-group">
						<label for="firstName" class="control-label">First Name</label> <input
							type="text" class="form-control" id="firstName" name="firstName"
							placeholder="Enter First Name" required>
						<div class="help-block with-errors"></div>
					</div>

					<div class="form-group">
						<label for="lastName" class="control-label">Last Name</label> <input
							type="text" class="form-control" id="lastName" name="lastName"
							placeholder="Enter Last Name" required>
						<div class="help-block with-errors"></div>
					</div>


					<div class="form-group">
						<label for="email" class="control-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							placeholder="Email" data-error="Email address is invalid"
							required>
						<div class="help-block with-errors"></div>
					</div>
					
					<div class="row">
					<div class="form-group col-md-6">
						<label for="gender" class="control-label">Gender</label>
						
							<select class="form-control" name="gender" id="gender" required>
								<option value="">Select Your Gender</option>
								<option value="M">M</option>
								<option value="F">F</option>
							</select>
						</div>
					</div>
					
					<br><br><br>
					<div class="form-group">
						<div class="checkbox">
							<label> <input type="checkbox" id="terms"
								data-error="Please accept the aggrement." required> I
								agree to use the service.
							</label>
							<div class="help-block with-errors"></div>
						</div>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>

			</div>

		</div>
	</form>
	
	<jsp:include page="footer.jsp" />

</body>
</html>
