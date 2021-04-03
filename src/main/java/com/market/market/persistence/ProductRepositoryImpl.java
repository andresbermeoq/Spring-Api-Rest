package com.market.market.persistence;

import com.market.market.domain.ProductDomain;
import com.market.market.domain.repository.ProductRepository;
import com.market.market.persistence.crud.ProductCrudRepository;
import com.market.market.persistence.entity.Product;
import com.market.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductDomain> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return productMapper.toProducts(products);
    }

    @Override
    public Optional<ProductDomain> getProduct(int idProduct) {
        return productCrudRepository.findById(idProduct).map(prods -> productMapper.toProduct(prods));
    }

    @Override
    public ProductDomain save(ProductDomain productDomain) {
        Product product1 = productMapper.toProductDomain(productDomain);
        return productMapper.toProduct(productCrudRepository.save(product1));
    }

    @Override
    public Optional<List<ProductDomain>> getByCategory(int idCategory) {
        List<Product> productsByCategory = productCrudRepository.findByIdCategoriesOrderByNameAsc(idCategory);
        return Optional.of(productMapper.toProducts(productsByCategory));
    }

    @Override
    public Optional<List<ProductDomain>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockLotLessThanAndState(quantity, true);
        return products.map(prods -> productMapper.toProducts(prods));
    }

    @Override
    public void delete(int idProduct) {
        productCrudRepository.deleteById(idProduct);
    }
}
