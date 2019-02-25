package com.justin.eCommerce.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stripe.Stripe;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.RateLimitException;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class StripeController {
	
//	CHECKOUT
	@SuppressWarnings("unused")
	@PostMapping("/checkout")
	public String checkout(@RequestParam("stripeToken") String stripeToken, HttpSession session) {
		Stripe.apiKey = "sk_test_iOnz5ITkLazFsTwIS1B3oTrL";

		String token = stripeToken;

		Map<String, Object> params = new HashMap<>();
		params.put("amount", session.getAttribute("amount"));
		params.put("currency", "usd");
		params.put("description", "Test charge");
		params.put("statement_descriptor", "Estates Winery");
		params.put("source", token);

		try {
			Charge charge = Charge.create(params);
			session.removeAttribute("cart");
			// Use Stripe's library to make requests...
		} catch (CardException e) {
			// Since it's a decline, CardException will be caught
		} catch (RateLimitException e) {
			// Too many requests made to the API too quickly
		} catch (InvalidRequestException e) {
			// Invalid parameters were supplied to Stripe's API
		} catch (AuthenticationException e) {
			// Authentication with Stripe's API failed
			// (maybe you changed API keys recently)
		} catch (ApiConnectionException e) {
			// Network communication with Stripe failed
		} catch (StripeException e) {
			// Display a very generic error to the user, and maybe send
			// yourself an email
		} catch (Exception e) {
			// Something else happened, completely unrelated to Stripe
		}

		return "redirect:/";
	}

}
