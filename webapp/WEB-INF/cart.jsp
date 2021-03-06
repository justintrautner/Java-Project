<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cart</title>
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
					class="badge primary cart-total" id="cart-badge"> <c:out
							value="${cart[0].total}" /></span>
			</a></li>
			<li><a href="/shop">Shop</a>
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
							class="badge primary" id="cart-badge"><c:out
									value="${cart[0].total}" /></span>
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
					<li><span class="show-for-sr">Current: </span> Cart</li>
				</ul>
			</nav>
		</div>
	</div>

	<!-- BODY -->
	<div class="grid-container medium-grid-frame" id="hadj">
		<div class="grid-x grid-padding-x grid-padding-y">
			<div class="cell medium-2"></div>
			<div class="cell medium-8">
				<c:choose>
					<c:when test="${cartItems.size()==1}">
						<h1>Cart is empty.</h1>
					</c:when>
					<c:otherwise>
						<table class="unstriped">
							<thead>
								<tr>
									<th>Item</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cartItems}" var="item" begin="1"
									varStatus="loop">
									<tr>
										<td><a href="wine${item.id}"> <c:out
													value="${item.name}" />
										</a></td>
										<td>$<c:out value="${item.price}" /></td>
										<td><c:out value="${item.quantity}" /> <a
											href="/remove/${loop.index}">Remove</a></td>
										<td>$<c:out value="${item.total}" />
										</td>
									</tr>
								</c:forEach>
								<tr>
									<td></td>
									<td></td>
									<td class="strong"><c:out value="${cartItems[0].total}" />
										items</td>
									<td class="strong">$<c:out
											value="${cartItems[0].totalPrice}" /></td>
								<tr>
							</tbody>
						</table>
						<div class="flex-container align-right">


							<form action="/checkout" method="POST">
								<script src="https://checkout.stripe.com/checkout.js"
									class="stripe-button"
									data-key="pk_test_LrqhJc59fQmN9VDJEC6D0CEA"
									data-amount="${amount}" data-name="Fancy Estates Winery"
									data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
									data-label="Checkout" data-locale="auto"
									data-shipping-address="true" data-billing-address="true">
									
								</script>
							</form>

						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="cell medium-2"></div>
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


