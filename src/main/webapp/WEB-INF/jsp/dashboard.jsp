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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="assets/css/main.css" />
		
	</head>
	
	<style>
	.border_cre{
		border:5px solid black;
	}
	</style>
	<body class="homepage is-preload">
		
	

		<div id="page-wrapper">
			<script src="https://apps.elfsight.com/p/platform.js" defer></script>
<div class="elfsight-app-2981a701-6491-4319-9679-c6547e55c75b"></div>

			<!-- Header -->
				<div id="header-wrapper">
					<div class="container">

						<!-- Header -->
							<header id="header">
								<div class="inner">

									<!-- Logo -->
										<h1><a href="/getDashboardPage" id="logo">ABC Job Community</a></h1>

									<!-- Nav -->
										<nav id="nav">
											<ul>
												<li class="current_page_item"><a href="/getDashboardPage">Home</a></li>
												
												<li>
												
												<button type="button" class="btn btn-outline-dark me-2" style="border: none;">
								            	@<c:out value="${pageContext.request.remoteUser}" />
								                </button>
								                
								                <ul>
				                                <li><a  href="/profile?id=${loggedinuser.id}">Profile</a></li>
				                                <li><a  href="/jobs">jobs</a></li>
				                              </ul>
				                       
								                </li>
												
								                <li>
								                
												<form action="/logout" method="post">
									            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						            	        <button type="submit" class="btn btn-success">Logout</button>
							                    </form>
							                    </li>
												

											</ul>
										</nav>

								</div>
							</header>



					</div>
				</div>

			<!-- Main Wrapper -->
				<div id="main-wrapper">
					<div class="wrapper style1">
						<div class="inner">
						
						<section>
			        	<div class="container mt-3">
								<c:url var="search_url" value="/dashboard" />
								<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			                    <form:form role="search" action="${search_url}" method="post">
			                        <div class="input-group">
			                            	<input class="form-control" name="keyword" type="search" placeholder="Search" aria-label="Search">
			                            	<button class="btn btn-success me-2" type="submit">Search</button>
			                            	<a href="/getDashboardPage" class="btn btn-danger">Default</a>
			                        </div>
			                    </form:form>
			            </div>
			        </section>
						
							<section class="container"><br>
							  
							  <h2>User Account</h2>
							
							  
							  <c:if test="${not empty users}">
								<c:forEach var="user" items="${users}">
								<div class="col-md-12 col-lg-4 col-sm-3">
								<div class="card" >
							 
								
							    <div class="card-body">
							      <h3 class="card-title">${user.username}</h3>
							      <p class="card-text">Email : ${user.email}</p>
							      <p class="card-text">First Name : ${user.firstname}</p>
							      <p class="card-text">Last Name : ${user.lastname}</p>
							      <p class="card-text">Company : ${user.company}</p>
							      <p class="card-text">City : ${user.city}</p>
							      <p class="card-text">Country : ${user.country}</p>
							      <a class="btn btn-success" href="/profile?id=${user.id}">Edit Profile</a>
							      <a onclick="deleteConfirm()" class="btn btn-success" href="/delete?id=${user.id}">Delete Profile</a>
							   
							    </div>
							    
							    </div>
							    </div>
						        </c:forEach>
						        </c:if>
							 
							</section>
						</div>
					</div>


				</div>

				<!-- Footer Wrapper -->
				<div id="footer-wrapper">
					<footer id="footer" class="container">

					</footer>
				</div>


		</div>

		<!-- Scripts -->
		
		<script>
		function deleteConfirm() {
		  confirm("delete the user?");
		}
		</script>
		
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
			<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

	</body>
</html>