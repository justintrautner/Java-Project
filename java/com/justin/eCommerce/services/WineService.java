package com.justin.eCommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.eCommerce.models.Wine;
import com.justin.eCommerce.repositories.WineRepo;

@Service
public class WineService {
	
	private final WineRepo wineRepo;
	
	public WineService(WineRepo wineRepo) {
		this.wineRepo=wineRepo;
	}
	
	public List<Wine>findAll(){
		return this.wineRepo.findAll();
	}
	
	public Wine findWineById(Long id) {
		Optional<Wine> wine = wineRepo.findById(id);
		
		if(wine.isPresent()) {
			return wine.get();
		}else {
			return null;
		}
	}

}
