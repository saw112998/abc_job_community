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
																	<form  class="mb-4" action="/update-jobs" method="post" modelAttribute="post">
																	
																	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
																	
																	<div class="mb-3">
														            <label class="form-label">ID: </label>
														            <input class="form-control" name="id" value="${post.id}" aria-label="Store ID" readonly="true" />
														          </div>
														          
														          <div class="mb-3">
														            <label class="form-label">Company: </label>
														            <input type="text" class="form-control" name="company" id="company" value="${post.company}" aria-label="username"  />
														          </div>
														          
														          <div class="mb-3">
														            <label class="form-label">Position: </label>
														            <input type="text" class="form-control" name="position" id="position" value="${post.position}" aria-label="username"  />
														          </div>
														          
														          <div class="mb-3">
														            <label class="form-label">City: </label>
														            <input type="text" class="form-control" name="city" id="city" value="${post.city}" aria-label="username"  />
														          </div>
														          
														          <div class="mb-3">
														            <label class="form-label">Country: </label>
														            <input type="text" class="form-control" name="country" id="country" value="${post.country}" aria-label="username"  />
														          </div>
														          
														          <div class="mb-3">
														            <label class="form-label">Salary: </label>
														            <input type="text" class="form-control" name="salary" id="salary" value="${post.salary}" aria-label="username"  />
														          </div>
														          
														          <div class="mb-3">
														            <label class="form-label">Content: </label>
														            <input type="text" class="form-control" name="content" id="content" value="${post.content}" aria-label="username"  />
														          </div>


														          
														        
														          
														          <div class="py-5">
														          <button type="submit" class="btn btn-success">Update</button>
														            <a href="/jobs" class="btn btn-danger">Back</a>
														            
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