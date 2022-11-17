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
												<h2>Update Profile</h2>
												
											</header>

										</article>
                               
                                            <div class="inner">
                                                <div class="container">
                                                    <div class="list-group-item list-group-item-info">
                                                        <div class="col-8 col-12-medium">
                    
                                                            <!-- Spotlight -->
                                                                <section class="box spotlight">
																	<form  class="mb-4" action="/update-profile" method="post" modelAttribute="user">
																	
																	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
																	
																	<div class="mb-3">
														            <label class="form-label">ID: </label>
														            <input class="form-control" name="id" value="${user.id}" aria-label="Store ID" readonly="true" />
														          </div>

														          <div class="mb-3">
														            <label class="form-label">*Username: </label>
														            <input type="text" class="form-control" name="username" id="username" value="${user.username}" aria-label="username" required />
														          </div>
														  
														          <div class="mb-3">
														            <label class="form-label">*Email: </label>
														            <input type="email" class="form-control" name="email" id="email" value="${user.email}" aria-label="email" required />
														          </div>
														  
														          <div class="mb-3">
														            <label class="form-label">*First Name: </label>
														            <input class="form-control" name="firstname" id="firstname" value="${user.firstname}" aria-label="first name"  />
														          </div>
														  
														          <div class="mb-3">
														            <label class="form-label">*Last Name: </label>
														            <input class="form-control" name="lastname" id="lastname" value="${user.lastname}" aria-label="last name"  />
														          </div>
														  
														          <div class="mb-3">
														            <label class="form-label">*Company: </label>
														            <input class="form-control" name="company" id="company" value="${user.company}" aria-label="company"  />
														          </div>

														          <div class="mb-3">
														            <label class="form-label">*City: </label>
														            <input class="form-control" name="city" id="city" value="${user.city}" aria-label="country"  />
														          </div>

														          <div class="mb-3">
														            <label class="form-label">*Country: </label>
														            <input class="form-control" name="country" id="country" value="${user.country}" aria-label="country"  />
														          </div><br>
														        
														          
														          <div class="py-5">
														          <button type="submit" class="btn btn-success">Update</button>
														            <a href="/getDashboardPage" class="btn btn-danger">Back</a>
														            
														          </div>
																	</form>
                                                                 

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