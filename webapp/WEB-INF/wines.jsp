<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shop</title>
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

	<!-- Off canvas -->
	<div class="off-canvas position-left" id="offCanvas" data-off-canvas>
		<!-- Mobile Menu -->
		<ul class="vertical menu accordion-menu" data-accordion-menu>
			<li><a href="/cart" id="cart-tag"> <i
					class="fi-shopping-cart" id="lg-cart"></i> <span
					class="badge primary cart-total-mobile" id="cart-badge"> <c:out
							value="${cart[0].total}" /></span>
			</a></li>
			<li><a href="" class="">Shop</a>
				<ul class="menu vertical nested">
					<li><a href="/shop">All</a></li>
					<c:forEach items="${cats}" var="cat">
						<li><a href="/shop"><c:out value="${cat.tag}" /></a></li>
					</c:forEach>
				</ul></li>
			<li><a href="/about">About us</a></li>
			<li><a href="/contact">Contact</a></li>
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

	<div class="grid-container">
		<div class="grid-x">
			<nav aria-label="You are here:" role="navigation" class="mt-3">
				<ul class="breadcrumbs">
					<li><a href="/">Home</a></li>
					<li><span class="show-for-sr">Current: </span> Wines</li>
				</ul>
			</nav>
		</div>
	</div>

	<!-- BODY -->
	<div class="grid-y medium-grid-frame">
		<div class="cell medium-auto medium-cell-block-container">
			<div class="grid-x grid-padding-x">
				<div class="cell medium-3">
					<ul class="vertical menu accordion-menu" data-accordion-menu>
						<li><a href="#">Category</a>
							<ul class="menu vertical nested">
								<li><a value="0" class="cat-filter strong">All</a></li>
								<c:forEach items="${cats}" var="cat">
									<li><a value="${cat.id }" class="cat-filter"><c:out
												value="${cat.tag}" /></a></li>
								</c:forEach>
							</ul></li>
						<li><a href="#">Price</a>
							<ul class="menu vertical nested">
								<li><a value="0" class="price-filter strong">All</a></li>
								<li><a value="25" class="price-filter">Under $25</a></li>
								<li><a value="50" class="price-filter">Under $50</a></li>
								<li><a value="51" class="price-filter">$50+</a></li>
							</ul></li>
					</ul>
				</div>
				<p class="callback"></p>
				<div class="cell medium-9 medium-cell-block-y">
					<div class="grid-container">
						<div class="grid-x grid-margin-x wine-data">
							<c:forEach items="${allWines}" var="wine">
								<div class="cell medium-6 small-12 large-4">
									<div class="card">

										<img src="${wine.image}" alt="" />

										<div class="card-section">
											<div class="flex-container align-justify align-middle">
												<h4>
													<a href="/wine${wine.id }"> <c:out value="${wine.name}" />
													</a>
												</h4>
												<h5>
													$
													<c:out value="${wine.price}" />
												</h5>
											</div>
											<p>
												<c:out value="${wine.description}" />
											</p>
											<div class="flex-container align-right">
												<button class="hollow button expanded add-to-cart"
													value="${wine.id}">
													<div class="flex-container align-justify">
														Add to Cart <i class="fi-shopping-cart"></i>
													</div>
												</button>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
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
					<a href="/about" class="strong">About Us</a>
					<a href="#" class="strong">FAQs</a>
					<a href="/contact" class="strong">Contact Us</a>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
	<script src="js/vendor/what-input.js"></script>
	<script src="js/vendor/foundation.min.js"></script>
	<script src="js/app.js"></script>
</body>

</html>


