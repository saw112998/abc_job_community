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

										<article>
											<header class="major">
												<h2>Sign In</h2>
												
											</header>

										</article>
                               
                                            <div class="inner">
                                                <div class="container">
                                                    <div class="list-group-item list-group-item-info">
                                                        <div class="col-8 col-12-medium">
                    
                                                            <!-- Spotlight -->
                                                                <section class="box spotlight">
																	<form  class="mb-4" action="/login" method="post">
																	
																	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                                        
                                                                        <div class="form-group mt-2">
                                                                            <label for="email" class="visually-hidden">email</label>
                                                                            <input type="email" name="email" id="email" class="form-control" placeholder="Email" required>
                                                                        </div>
                                                                        
                                                                        <div class="form-group mt-2 mb-5">
                                                                            <label for="password" class="visually-hidden">password</label>
                                                                            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
                                                                        </div>
                                                                        
                                                                        <div class="form-group d-grid gap-2">
                                                                            <button name="submit" class="btn btn-success w-100">Sign In</button>
                                                                            <button class="btn btn-info w-100" onclick="location.href='/getHomePage'">Back</button>
                                                                        </div>
                                                                        <a href="/forgot_password">Forgot your password?</a>
																	</form>
																	
													                <c:if test="${error_string != null}">
																	<div class="alert alert-danger mt-3">
																	alert("ajax failed" +uname);
																	</div>
																</c:if>

                                                                </section>
                    
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