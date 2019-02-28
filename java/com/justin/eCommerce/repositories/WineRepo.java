package com.justin.eCommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.eCommerce.models.Wine;

@Repository
public interface WineRepo extends CrudRepository<Wine, Long> {

	List<Wine> findAll();

	List<Wine> findByCategories_Id(Long id);

	List<Wine> findByPriceLessThan(Float val);

	List<Wine> findByPriceGreaterThan(Float val);

	@Query(value = "SELECT * FROM wines JOIN wine_categories ON wines.id=wine_categories.wine_id WHERE wines.price > ?2 AND wine_categories.category_id=?1", nativeQuery=true)
	List<Wine> findByCatIdAndPriceGreaterThan(long catId, Float val);

	@Query(value = "SELECT * FROM wines JOIN wine_categories ON wines.id=wine_categories.wine_id WHERE wines.price < ?2 AND wine_categories.category_id=?1", nativeQuery=true)
	List<Wine> findByCatIdAndPriceLessThan(long catId, Float val);

	List<Wine> findByIsFeaturedTrue();

}
