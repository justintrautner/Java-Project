<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<link rel="stylesheet" type="text/css" href="css/foundation.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet"
	href="icons/foundation-icons/foundation-icons.css">
<link href="https://fonts.googleapis.com/css?family=Tangerine"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
</head>
<body>

	<div class="off-canvas position-left" id="offCanvas" data-off-canvas>
		<!-- Mobile Menu -->
		<ul class="vertical menu accordion-menu" data-accordion-menu>
			<li><a href="/cart" id="cart-tag"> <i
					class="fi-shopping-cart" id="lg-cart"></i> <span
					class="badge primary cart-total" id="cart-badge"> <c:out
							value="${cart[0].total}" /></span>
			</a></li>
			<li><a href="/shop" class="">Shop</a>
				<ul class="menu vertical nested">
					<li><a href="/shop">All</a></li>
					<c:forEach items="${cats}" var="cat">
						<li><a href="/shop"><c:out value="${cat.tag}" /></a></li>
					</c:forEach>
				</ul></li>
			<li><a href="/about" class="">About us</a></li>
			<li><a href="/contact" class="">Contact</a></li>
		</ul>
	</div>

	<div class="off-canvas-content" data-off-canvas-content>
		<div class="title-bar" id="p-0" data-responsive-toggle="example-menu"
			data-hide-for="medium">
			<button type="button" class="menu-icon" data-toggle="offCanvas"></button>
			<div class="title-bar-title fancy-text">Fancy Estates</div>
		</div>
		<!-- Nav -->
		<div class="top-bar bst" id="example-menu">
			<div class="top-bar-left">
				<ul class="dropdown menu" data-dropdown-menu>
					<li class="menu-text fancy-text" id="p-0">Fancy Estates</li>
					<li><a href="/shop">Shop</a>
						<ul class="menu vertical">
							<li><a href="/shop">All</a></li>
							<c:forEach items="${cats}" var="cat">
								<li><a href="/shop"><c:out value="${cat.tag}" /></a></li>
							</c:forEach>
						</ul></li>
					<li><a href="/about">About us</a></li>
					<li><a href="/contact">Contact</a></li>
				</ul>
			</div>
			<div class="top-bar-right">
				<ul class="menu">
					<li><input type="search" placeholder="Search"
						id="search-wines"></li>
					<li><button type="button" class="button">Search</button></li>
					<li><a href="/cart" id="cart-tag"> <i
							class="fi-shopping-cart" id="lg-cart"></i> <span
							class="badge primary cart-total" id="cart-badge"> <c:out
									value="${cart[0].total}" />
						</span>
					</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- Breadcrumbs -->
	<div class="grid-container">
		<div class="grid-x">
			<nav aria-label="You are here:" role="navigation" class="mt-3">
				<ul class="breadcrumbs">
					<li><a href="/">Home</a></li>
					<li><span class="show-for-sr">Current: </span>Admin</li>
				</ul>
			</nav>
		</div>
	</div>

	<!-- Body -->
	<div class="grid-container" id="hadj">

		<h1>Admin</h1>
		<a class="button success" href="/admincreatewine">Create Wine</a> <a
			class="button success" href="/admincreatecategory">Create
			Category</a>
		<ul class="accordion" data-accordion data-multi-expand="true">
			<li class="accordion-item is-active" data-accordion-item><a
				href="#" class="accordion-title">Wines</a>
				<div class="accordion-content" data-tab-content>
					<table class="stack">
						<thead>
							<tr>
								<th>Name</th>
								<th>Description</th>
								<th>Image</th>
								<th>Price</th>
								<th>Category</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${wines}" var="wine">
								<tr>
									<td><c:out value="${wine.name}" /></td>
									<td><c:out value="${wine.description}" /></td>
									<td><c:out value="${wine.image}" /></td>
									<td><c:out value="${wine.price}" /></td>
									<td><c:forEach items="${wine.categories}" var="cat">
											<c:out value="${cat.tag}" />
										</c:forEach></td>
									<td><a class="button warning" href="/editwine${wine.id }">Edit</a>
										<a class="button alert" href="/delete/wine/${wine.id }">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div></li>
			<li class="accordion-item" data-accordion-item><a href="#"
				class="accordion-title">Categories</a>
				<div class="accordion-content" data-tab-content>
					<table class="stack">
						<thead>
							<tr>
								<th>Tag</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${cats}" var="cat">
								<tr>
									<td><c:out value="${ cat.tag}" /></td>
									<td><a class="button alert" href="/delete/cat/${cat.id }">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div></li>
		</ul>



	</div>
	<!-- Footer -->
	<div class="grid-container fluid bsf" id="footer">
		<div class="grid-x align-center">
			<div class="cell small-8 medium-3">
				<div class="flex-container align-justify">
					<i class="fi-social-facebook foot-icon"></i> <i
						class="fi-social-instagram foot-icon"></i> <i
						class="fi-social-twitter foot-icon"></i> <i
						class="fi-social-pinterest foot-icon"></i> <i
						class="fi-social-youtube foot-icon"></i>
				</div>
			</div>
		</div>
		<div class="grid-x align-center">
			<div class="cell small-8 medium-3">
				<div class="flex-container align-justify">
					<a href="/about" class="strong">About Us</a> <a href="#"
						class="strong">FAQs</a> <a href="/contact" class="strong">Contact
						Us</a>
				</div>
			</div>
		</div>
		<div class="grid-x align-center">
			<div class="cell small-8 medium-6">
				<div class="flex-container align-center">
					<p>&copy; Fancy Estates Winery and Co. All rights reserved.</p>
				</div>
			</div>
		</div>
	</div>

	<script src="js/vendor/jquery.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="js/vendor/what-input.js"></script>
	<script src="js/vendor/foundation.min.js"></script>
	<script src="js/app.js"></script>

</body>
</html>