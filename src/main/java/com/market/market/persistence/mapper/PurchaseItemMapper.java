package com.market.market.persistence.mapper;

import com.market.market.domain.PurchaseItem;
import com.market.market.persistence.entity.ComprasProductos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "comprasProductosPK.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active"),
    })
    PurchaseItem toPurchaseItem(ComprasProductos comprasProductos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "comprasProductosPK.idCompra", ignore = true),
    })
    ComprasProductos toComprasProducto(PurchaseItem purchaseItem);
}
