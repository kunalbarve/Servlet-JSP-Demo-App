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
	<jsp:include page="header.jsp" />

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
								<th>Delete</th>
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
										</c:if>
									</td>
									<td>
										<button type="button" class="btn btn-warning" onclick="createRequest('/DemoProject/HomeServlet', {mode: 'deleteData', id: '${user.id}'}, 'post');">Delete</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>

		</div>
	</form>

	<jsp:include page="footer.jsp" />

</body>

<script type="text/javascript">
	function createRequest(path, params, method) {
	    method = method || "post"; // Set method to post by default if not specified.
	    // The rest of this code assumes you are not using a library.
	    // It can be made less wordy if you use one.
	    var form = document.createElement("form");
	    form.setAttribute("method", method);
	    form.setAttribute("action", path);
	    	
	    for(var key in params) {
	        if(params.hasOwnProperty(key)) {
	            var hiddenField = document.createElement("input");
	            hiddenField.setAttribute("type", "hidden");
	            hiddenField.setAttribute("name", key);
	            hiddenField.setAttribute("value", params[key]);
	            form.appendChild(hiddenField);
	         }
	    }

	    document.body.appendChild(form);
	    form.submit();
	}
	
</script>

</html>