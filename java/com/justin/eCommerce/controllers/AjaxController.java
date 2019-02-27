package com.justin.eCommerce.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.justin.eCommerce.models.Category;
import com.justin.eCommerce.models.Wine;
import com.justin.eCommerce.services.CategoryService;
import com.justin.eCommerce.services.WineService;

@RestController
public class AjaxController {

	private final CategoryService catService;
	private final WineService wineService;

	public AjaxController(WineService wineService, CategoryService catService) {
		this.catService = catService;
		this.wineService = wineService;
	}

//	FILTER CATEGORIES
	@GetMapping("/api/cats/{id}")
	public List<Wine> filterCat(@PathVariable("id") Long id, HttpSession session) {
		float pFilter = (float) session.getAttribute("price-filter");
		session.setAttribute("cat-filter", id);
		// All category
		if (id == 0) {
			// All Price
			if (pFilter == 0) {
				List<Wine> wines = wineService.findAll();
				return wines;
			}
			//	Greater Than
			if(pFilter == 51) {
				List<Wine> wines =wineService.findByPriceGreaterThan(pFilter);
				return wines;
			//	Less Than				
			}else {
				List<Wine> wines=wineService.findByPriceLessThan(pFilter);
				return wines;
			}
		// Category filter
		} else {
			//	All Price
			if(pFilter ==0) {
				Category category = catService.findCategoryById(id);
				List<Wine> wines = category.getWines();
				return wines;
			}
			//	Greater Than
			if(pFilter ==51) {
				List<Wine> wines = wineService.findByCatIdAndPriceGreaterThan(id, pFilter);
				return wines;
			// Less than			
			}else {
				List<Wine> wines =wineService.findByCatIdAndPriceLessThan(id, pFilter);
				return wines;
			}
		}
	}

//	FILTER PRICE
	@GetMapping("/api/price/{val}")
	public List<Wine> filterPrice(@PathVariable("val") Float val, HttpSession session) {
		session.setAttribute("price-filter", val);
		// No category filter
		if (Math.toIntExact((long) session.getAttribute("cat-filter")) == 0
				|| session.getAttribute("cat-filter") == null) {
			// All
			if (val.compareTo((float) 0) == 0) {
				List<Wine> wines = wineService.findAll();
				return wines;
			}
			// Greater than
			if (val.compareTo((float) 51) == 0) {
				List<Wine> wines = wineService.findByPriceGreaterThan(val);
				return wines;
			// Less than value
			} else {
				List<Wine> wines = wineService.findByPriceLessThan(val);
				return wines;
			}
			// Category filter
		} else {
			// All
			if (val.compareTo((float) 0) == 0) {
				List<Wine> wines = wineService.findByCatId((long) session.getAttribute("cat-filter"));
				return wines;
			}
			// Greater than
			if (val.compareTo((float) 51) == 0) {
				List<Wine> wines = wineService.findByCatIdAndPriceGreaterThan((long) session.getAttribute("cat-filter"),
						val);
				return wines;
				// Less than
			} else {
				List<Wine> wines = wineService.findByCatIdAndPriceLessThan((long) session.getAttribute("cat-filter"),
						val);
				return wines;
			}
		}
	}

//	AUTOCOMPLETE
	@GetMapping("/api/wines")
	public List<Wine> auto() {
		List<Wine> wines = wineService.findAll();
		return wines;
	}

}
