package com.market.market.persistence.crud;

import com.market.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByIdCategoriesOrderByNameAsc(int idCategories);
    Optional<List<Product>> findByStockLotLessThanAndState(int stockLot, boolean state);
}
