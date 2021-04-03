package com.market.market.persistence.crud;

import com.market.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findByCategoriaOrderByNombre(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidaStock, boolean estado);

}
