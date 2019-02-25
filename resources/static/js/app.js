$(document).foundation().ready(function() {

	// Add to Cart
	$(".add-to-cart").click(function() {
		var id = $(this).attr("value");
		var self = $(this);
		$.post("/add", {
			id : id
		}, function(data, status) {

		});
		self.addClass("spin-cw").addClass("slow");
		$(".cart-total").text(parseInt($(".cart-total").text()) + 1);
		setTimeout(function() {
			self.removeClass('spin-cw');
		}, 750);
	});
	// Filter
	$(".cat-filter").click(function() {

		$.ajax({
			url : '/cats/' + $(this).attr("value"),
			method : 'GET',
			contentType : "application/json",
			dataType : "json",
			success : function(data) {
				results = data;
				for (var i = 0; i < data.length; i++) {
					console.log(i);
					console.log(data[i]['id']);

				}
			}
		})

	});
	// END
});