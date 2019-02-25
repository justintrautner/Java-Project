package com.justin.eCommerce.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.justin.eCommerce.models.Category;
import com.justin.eCommerce.models.Wine;
import com.justin.eCommerce.services.CategoryService;

@RestController
public class AjaxController {
	
	private final CategoryService catService;

	public AjaxController(CategoryService catService) {
		this.catService = catService;
	}
	
	@GetMapping("/cats/{id}")
	public List<Wine> ajax(@PathVariable("id") Long id) {
		Category category = catService.findCategoryById(id);
		List<Wine> wines = category.getWines();
		return wines;
	}

}
