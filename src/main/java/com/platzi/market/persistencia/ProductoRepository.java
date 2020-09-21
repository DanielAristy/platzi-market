package com.platzi.market.persistencia;

import com.platzi.market.persistencia.crud.ProductoCrudRepository;
import com.platzi.market.persistencia.entidad.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*Esta clase se encarga de interactuar con la base de datos**/
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
    
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getProductosEscasos(int cantidad_stock){
        return productoCrudRepository.findByCantidadStockIsLessThanAndEstado(cantidad_stock, true );
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
