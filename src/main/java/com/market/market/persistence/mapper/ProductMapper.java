package com.market.market.persistence.mapper;

import com.market.market.domain.ProductDomain;
import com.market.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducts", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategories", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "stockLot", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "categoryAdd", target = "category")

    })
    ProductDomain toProduct(Product product);
    List<ProductDomain> toProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProductDomain(ProductDomain productDomain);
}

