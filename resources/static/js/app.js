$(document).foundation().ready(function() {

	// Add to Cart
	$("body").on("click", ".add-to-cart", function(e) {
		e.stopPropagation();
		var id = $(this).attr("value");
		var self = $(this);
		$.ajax({
			url: '/add',
			method: 'POST',
			data: {id: id},
			success: function(data){
				
			}
		})
		self.addClass("spin-cw").addClass("slow");
		$(".cart-total").text(parseInt($(".cart-total").text()) + 1);
		$(".cart-total-mobile").text(parseInt($(".cart-total").text()));
		setTimeout(function() {
			self.removeClass('spin-cw');
		}, 750);
	});
	// AutoComplete
	$(function (){
		$.ajax({
			url: '/api/wines',
			method: 'GET'
		})
		.done((data)=>{
			$("#search-wines").autocomplete({
				minLength: 1,
				source: function( request, response ) {
	                var matcher = new RegExp( "^" +   $.ui.autocomplete.escapeRegex( request.term ), "i" );
	                response( $.grep( data, function( item ){
	                    return matcher.test(item.name );
	                }) );
				},
				select: function (event, ui) {
					$("#search-wines").val(ui.item.name);
					$("#search-wines-id").val(ui.item.id);
					return false;
				}
			}).autocomplete("instance")._renderItem = function (ul, item) {
				return $("<li>").append(
					"<div><a href='/wine" + item.id + "'>"
					+ item.name + "</a></div>").appendTo(ul);
			};
		})
		
	});
	// Filter categories
	$(".cat-filter").click(function() {
		$(".cat-filter").removeClass("strong");
		$(this).addClass("strong");
		$.ajax({
			url : '/api/cats/' + $(this).attr("value"),
			method : 'GET',
			contentType : "application/json",
			dataType : "json",
			success : function(data) {
				$(".wine-data").empty();
				if(data.length==0){
					$(".wine-data").append("<h2> No Results </h2>")
				}else{
					for (var i = 0; i < data.length; i++) {
						$(".wine-data").append("<div class='cell medium-6 small-12 large-4'><div class='card'><img src="
										+ data[i]['image']
										+ "/><div class='card-section'><div class='flex-container align-justify align-middle'><h4><a href='/wine"
										+ data[i]['id']
										+ "'>"
										+ data[i]['name']
										+ "</a></h4><h5>$"
										+ data[i]['price']
										+ "</h5></div><p>"
										+ data[i]['description']
										+ "</p><div class='flex-container align-right'><button class='hollow button expanded add-to-cart' value="
										+ data[i]['id']
										+ "><div class='flex-container align-justify'>Add to Cart <i class='fi-shopping-cart'></i></div></button></div></div></div></div>")
					}
				}
			}
		})

	}); 
// Filter Price
	$(".price-filter").click(function(e){
		$(".price-filter").removeClass("strong");
		$(this).addClass("strong");
		$.ajax({
			url: '/api/price/'+ $(this).attr("value"),
			method: 'GET',
			contentType : "application/json",
			dataType : "json",
			success: function(data){
				$(".wine-data").empty();
				if(data.length==0){
					$(".wine-data").append("<h2> No Results </h2>")
				}else{
					for (var i = 0; i < data.length; i++) {
						$(".wine-data").append("<div class='cell medium-6 small-12 large-4'><div class='card'><img src="
										+ data[i]['image']
										+ "/><div class='card-section'><div class='flex-container align-justify align-middle'><h4><a href='/wine"
										+ data[i]['id']
										+ "'>"
										+ data[i]['name']
										+ "</a></h4><h5>$"
										+ data[i]['price']
										+ "</h5></div><p>"
										+ data[i]['description']
										+ "</p><div class='flex-container align-right'><button class='hollow button expanded add-to-cart' value="
										+ data[i]['id']
										+ "><div class='flex-container align-justify'>Add to Cart <i class='fi-shopping-cart'></i></div></button></div></div></div></div>")
					}
				}
			}
		})
		
	});
	
	
});  /* END */