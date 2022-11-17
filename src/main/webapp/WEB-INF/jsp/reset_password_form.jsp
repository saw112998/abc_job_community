<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	<title>ABC Job Community</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="assets/css/main.css" />
		



	</head>
	<body class="no-sidebar is-preload">
		<div id="page-wrapper">



			<!-- Main Wrapper -->
				<div id="main-wrapper">
					<div class="wrapper style2">
						<div class="inner">
							<div class="container">
								<div id="content">

									<!-- Content -->


                               
                                            <div class="inner">
                                                <div class="container">
                                                    <div class="list-group-item list-group-item-info">
                                                        <div class="col-8 col-12-medium">
                    
                                                        <div>
                                                        <h2>Reset Your Password</h2>
                                                    </div>
                                                             
                                                    <form th:action="@{/reset_password}" method="post" style="max-width: 350px; margin: 0 auto;">
                                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                    <div class="border border-secondary rounded p-3">
                                                        <div>
                                                            <p>
                                                                <input type="password" name="password" id="password" class="form-control"
                                                                    placeholder="Enter your new password" required autofocus />
                                                            </p>         
                                                            <p>
                                                                <input type="password" class="form-control" placeholder="Confirm your new password"              
                                                                    required oninput="checkPasswordMatch(this);" />
                                                            </p>         
                                                            <p class="text-center">
                                                                <input type="submit" value="Change Password" class="btn btn-primary" />
                                                            </p>
                                                        </div>
                                                    </div>
                                                    </form>
                    
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                   
								</div>
							</div>
						</div>
					</div>
				


				</div>



		</div>

		<!-- Scripts -->
		
		<script>
		function checkPasswordMatch(fieldConfirmPassword) {
		    if (fieldConfirmPassword.value != $("#password").val()) {
		        fieldConfirmPassword.setCustomValidity("Passwords do not match!");
		    } else {
		        fieldConfirmPassword.setCustomValidity("");
		    }
		}
		</script>
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>