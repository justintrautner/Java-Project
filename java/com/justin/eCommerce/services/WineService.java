package com.justin.eCommerce.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	
	public List<Wine>findByCatId(Long id){
		return this.wineRepo.findByCategories_Id(id);
	}

	public List<Wine> findByPriceLessThan(Float val) {
		
		return this.wineRepo.findByPriceLessThan(val);
	}

	public List<Wine> findByPriceGreaterThan(Float val) {
		
		return this.wineRepo.findByPriceGreaterThan(val);
	}

	public List<Wine> findByCatIdAndPriceGreaterThan(long catId, Float val) {
		
		return this.wineRepo.findByCatIdAndPriceGreaterThan(catId, val);
	}

	public List<Wine> findByCatIdAndPriceLessThan(long catId, Float val) {
		
		return this.wineRepo.findByCatIdAndPriceLessThan(catId, val);
	}

	public Wine createWine(@Valid Wine newWine) {
		return wineRepo.save(newWine);
		
	}

	public void deleteWine(Long id) {
		wineRepo.deleteById(id);
		
	}

	public Wine updateWine(@Valid Wine updatedWine) {
		
		return wineRepo.save(updatedWine);
	}

}
