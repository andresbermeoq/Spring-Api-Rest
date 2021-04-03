package com.market.market.persistence.mapper;

import com.market.market.domain.CategoryDomain;
import com.market.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "state", target = "active")

    })
    CategoryDomain toCategory(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "productList", ignore = true)
    Category toCategoryDomain(CategoryDomain categoryDomain);
}
