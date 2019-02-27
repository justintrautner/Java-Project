package com.justin.eCommerce.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.justin.eCommerce.models.Category;
import com.justin.eCommerce.models.Wine;
import com.justin.eCommerce.services.CategoryService;
import com.justin.eCommerce.services.WineService;

@Controller
public class CartController {
	
	private final WineService wineService;
	private final CategoryService catService;

	public CartController(WineService wineService, CategoryService catService) {
		this.wineService = wineService;
		this.catService= catService;
	}
	
//	ADD TO CART
	@SuppressWarnings("unchecked")
	@PostMapping("/add")
	@ResponseStatus( HttpStatus.OK )
	public void addToCart(HttpSession session, @RequestParam("id") String id, Model model) {
		ArrayList<HashMap<String, String>> cart = (ArrayList<HashMap<String, String>>) session.getAttribute("cart");
		HashMap<String, String> product = new HashMap<String, String>();
		Wine wine = wineService.findWineById(Long.parseLong(id));
		if (cart.size() > 1) {
			boolean found = false;
			for (int i = 1; i < cart.size(); i++) {
				if (cart.get(i).get("id").equals(id)) {
					int q = Integer.parseInt(cart.get(i).get("quantity")) + 1;
					cart.get(i).put("quantity", Integer.toString(q));
					cart.get(i).put("total",
							String.format("%.2f", Float.parseFloat(cart.get(i).get("total")) + wine.getPrice()));
					found = true;
					break;
				}
			}
			if (found == false) {
				product.put("name", wine.getName());
				product.put("price", Float.toString(wine.getPrice()));
				product.put("id", id);
				product.put("quantity", "1");
				product.put("total", Float.toString(wine.getPrice()));
				cart.add(product);
			}
		} else {
			product.put("name", wine.getName());
			product.put("price", Float.toString(wine.getPrice()));
			product.put("id", id);
			product.put("quantity", "1");
			product.put("total", Float.toString(wine.getPrice()));
			cart.add(product);
		}
		int t = Integer.parseInt(cart.get(0).get("total")) + 1;
		cart.get(0).put("total", Integer.toString(t));
		cart.get(0).put("totalPrice",
				String.format("%.2f", Float.parseFloat(cart.get(0).get("totalPrice")) + wine.getPrice()));
	}

//	REMOVE FROM CART
	@SuppressWarnings("unchecked")
	@GetMapping("/remove/{idx}")
	public String remove(@PathVariable("idx") int idx, HttpSession session) {
		ArrayList<HashMap<String, String>> cart = (ArrayList<HashMap<String, String>>) session.getAttribute("cart");
		HashMap<String, String> product = cart.get(idx);
		cart.get(0).put("total", Integer
				.toString(Integer.parseInt(cart.get(0).get("total")) - Integer.parseInt(product.get("quantity"))));
		cart.get(0).put("totalPrice", String.format("%.2f",
				Float.parseFloat(cart.get(0).get("totalPrice")) - Float.parseFloat(product.get("total"))));
		cart.remove(idx);
		session.setAttribute("cart", cart);
		return "redirect:/cart";
	}

//	CART
	@SuppressWarnings("unchecked")
	@GetMapping("/cart")
	public String cart(HttpSession session, Model model) {
		model.addAttribute("cartItems", session.getAttribute("cart"));
		String amount = String.format("%.0f",
				Float.parseFloat(
						((ArrayList<HashMap<String, String>>) session.getAttribute("cart")).get(0).get("totalPrice"))
						* 100);
		model.addAttribute("amount", amount);
		session.setAttribute("amount", amount);
		List<Category> cats = catService.findAll();
		model.addAttribute("cats", cats);
		return "cart.jsp";

	}

}
