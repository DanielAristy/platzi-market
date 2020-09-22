package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Mapeo de clases usando mapstruct
 * Integracion con Spring*/
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    /*Conviertiendo categorias dentro de category**/
    @Mappings({
            @Mapping(source= "idCategoria", target= "categoryId"),
            @Mapping(source= "descripcion", target= "category"),
            @Mapping(source= "estado", target= "active")
    })
    Category toCategory(Categoria categoria);

    /**Convercion inversa a la de Mappings
     * No vamos a mapear las lista de productos*/
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
