package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /*Buscar los productos de una categoria ordenandolos
      por los nombres Ascendentemente
    * Query Methods */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    /*Buscar los productos que esten con muy poca cantidad
    en el stock y que este activos*/
    Optional<List<Producto>> findByCantidadStockIsLessThanAndEstado(int cantidadStock, boolean estado);
}
