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
                                                        <h2>Forgot Password</h2>
                                                    </div>

                                                    <div th:if="${error != null}">
                                                    <p class="text-danger" style="text-align: center;">${error}</p>
                                                </div>
                                                <div th:if="${message != null}">
                                                    <p class="text-warning" style="text-align: center;">${message}</p>
                                                </div>
                                                             
                                                    <form action="/forgot_password" method="post" style="max-width: 420px; margin: 0 auto;">
                                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                    <div class="border border-secondary rounded p-3">
                                                        <div>
                                                            <p>We will be sending a reset password link to your email.</p>
                                                        </div>
                                                        <div>
                                                            <p>
                                                                <input type="email" name="email" class="form-control" placeholder="Enter your e-mail" required autofocus/>
                                                            </p>         
                                                            <p class="text-center">
                                                            <button name="submit" class="btn btn-success w-100">Send Email</button>
                                                                <button class="btn btn-info w-100" onclick="location.href='/signin'">Back</button>
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
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>