package com.market.market.domain.service;

import com.market.market.domain.ProductDomain;
import com.market.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDomain> getAll() {
        return productRepository.getAll();
    }

    public Optional<ProductDomain> getProduct(int idProduct) {
        return productRepository.getProduct(idProduct);
    }

    public Optional<List<ProductDomain>> getByCategory(int idCategory) {
        return productRepository.getByCategory(idCategory);
    }

    public ProductDomain save(ProductDomain productDomain) {
        return productRepository.save(productDomain);
    }

    public boolean delete(int productID) {
        return getProduct(productID).map(product -> {
                productRepository.delete(productID);
                return true;
                }
            ).orElse(false);
    }

}
