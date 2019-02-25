<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="no-js" lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/foundation.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet"
	href="icons/foundation-icons/foundation-icons.css">
<link href="https://fonts.googleapis.com/css?family=Tangerine"
	rel="stylesheet">
</head>
<body>

	<!-- Off canvas -->
	<div class="off-canvas position-left" id="offCanvas" data-off-canvas>
		<!-- Mobile Menu -->
		<ul class="vertical menu accordion-menu" data-accordion-menu>
			<li><a href="" class="">Shop</a>
				<ul class="menu vertical nested">
					<li><a href="/shop">All</a></li>
					<li><a href="">Reds</a></li>
					<li><a href="">Whites</a></li>
				</ul></li>
			<li><a href="/about" class="">About us</a></li>
			<li><a href="" class="">Contact</a></li>
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
					<li><a href="#">Shop</a>
						<ul class="menu vertical">
							<li><a href="/shop">All</a></li>
							<li><a href="">Reds</a></li>
							<li><a href="">Whites</a></li>
						</ul></li>
					<li><a href="/about">About us</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</div>
			<div class="top-bar-right">
				<ul class="menu">
					<li><input type="search" placeholder="Search"></li>
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
	<!-- Orbit -->
	<div class="orbit" role="region" aria-label="Favorite Space Pictures"
		data-orbit
		data-options="animInFromLeft:fade-in; animInFromRight:fade-in; animOutToLeft:fade-out; animOutToRight:fade-out;">
		<div class="orbit-wrapper">
			<div class="orbit-controls">
				<button class="orbit-previous">
					<span class="show-for-sr">Previous Slide</span>&#9664;&#xFE0E;
				</button>
				<button class="orbit-next">
					<span class="show-for-sr">Next Slide</span>&#9654;&#xFE0E;
				</button>
			</div>
			<ul class="orbit-container">
				<li class="is-active orbit-slide">
					<figure class="orbit-figure">
						<img class="orbit-image"
							src="https://www.brassfieldestate.com/assets/images/contentblock/photos/home-slide-1-MWATGE.jpg"
							alt="Wine">
					</figure>
				</li>
				<li class="orbit-slide">
					<figure class="orbit-figure">
						<img class="orbit-image"
							src="https://www.brassfieldestate.com/assets/images/contentblock/photos/Vineyardresizedforwebsite.jpg"
							alt="Wine">
					</figure>
				</li>
				<li class="orbit-slide">
					<figure class="orbit-figure">
						<img class="orbit-image"
							src="https://www.brassfieldestate.com/assets/images/contentblock/photos/home-slide-3-OZRUQB.jpg"
							alt="Wine">
					</figure>
				</li>
			</ul>
		</div>
		<nav class="orbit-bullets">
			<button class="is-active" data-slide="0">
				<span class="show-for-sr">First slide.</span><span
					class="show-for-sr">Current Slide</span>
			</button>
			<button data-slide="1">
				<span class="show-for-sr">Second slide.</span>
			</button>
			<button data-slide="2">
				<span class="show-for-sr">Third slide.</span>
			</button>
		</nav>
	</div>
	<div class="grid-container">
		<div class="grid-x">
			<h1 class="m-0">FEATURED WINES</h1>
		</div>
		<hr>
		<div class="grid-x grid-margin-x">
			<div class="cell medium-auto small-12">
				<div class="card">
					<img src="https://via.placeholder.com/200x200" alt="">
					<div class="card-section">
						<div class="flex-container align-justify align-middle">
							<h4>Wine</h4>
							<h5>$19.99</h5>
						</div>
						<p>lloreum ipsum</p>
						<div class="flex-container align-right">
							<button class="hollow button expanded" href="#">
								<div class="flex-container align-justify">
									Add to Cart <i class="fi-shopping-cart"></i>
								</div>
							</button>
						</div>
					</div>
				</div>
			</div>
			<div class="cell medium-auto small-12">
				<div class="card">
					<img src="https://via.placeholder.com/200x200" alt="">
					<div class="card-section">
						<div class="flex-container align-justify align-middle">
							<h4>Wine</h4>
							<h5>$19.99</h5>
						</div>
						<p>lloreum ipsum</p>
						<div class="flex-container align-right">
							<button class="hollow button expanded" href="#">
								<div class="flex-container align-justify">
									Add to Cart <i class="fi-shopping-cart"></i>
								</div>
							</button>
						</div>
					</div>
				</div>
			</div>
			<div class="cell medium-auto small-12">
				<div class="card">
					<img src="https://via.placeholder.com/200x200" alt="">
					<div class="card-section">
						<div class="flex-container align-justify align-middle">
							<h4>Wine</h4>
							<h5>$19.99</h5>
						</div>
						<p>lloreum ipsum</p>
						<div class="flex-container align-right">
							<button class="hollow button expanded" href="#">
								<div class="flex-container align-justify">
									Add to Cart <i class="fi-shopping-cart"></i>
								</div>
							</button>
						</div>
					</div>
				</div>
			</div>
			<div class="cell medium-auto small-12">
				<div class="card">
					<img src="https://via.placeholder.com/200x200" alt="">
					<div class="card-section">
						<div class="flex-container align-justify align-middle">
							<h4>Wine</h4>
							<h5>$19.99</h5>
						</div>
						<p>lloreum ipsum</p>
						<div class="flex-container align-right">
							<button class="hollow button expanded" href="#">
								<div class="flex-container align-justify">
									Add to Cart <i class="fi-shopping-cart"></i>
								</div>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="grid-container mb-5">
		<h2 class="mt-5">SHOP BY CATEGORY</h2>
		<hr>
		<div class="grid-x grid-padding-x align-center-middle text-center">
			<div
				class="cell medium-4 small-12 mb-2 hover-opacity image-hover-wrapper">
				<a href=""> <img src="https://via.placeholder.com/350x350"
					alt=""> <span class="image-hover-wrapper-reveal">
						<p class="h2">RED</p>
				</span>
				</a>
				<h2 class="show-for-small-only">RED</h2>
			</div>
			<div
				class="cell medium-4 small-12 mb-2 hover-opacity image-hover-wrapper">
				<a href=""> <img src="https://via.placeholder.com/350x350"
					alt=""> <span class="image-hover-wrapper-reveal">
						<p class="h2">WHITE</p>
				</span>
				</a>
				<h2 class="show-for-small-only">WHITE</h2>
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
					<p class="strong">FAQs</p>
					<p class="strong">Contact Us</p>
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
	<script src="js/vendor/what-input.js"></script>
	<script src="js/vendor/foundation.min.js"></script>
	<script src="js/app.js"></script>
</body>

</html>


