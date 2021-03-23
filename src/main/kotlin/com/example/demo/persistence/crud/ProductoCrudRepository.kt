package com.example.demo.persistence.crud

import com.example.demo.persistence.entity.Producto
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ProductoCrudRepository : CrudRepository<Producto?, UUID?> {
    @Query(value = "SELECT * FROM productos WHERE id_categoria=?", nativeQuery = true)
    fun getByCategoria(idcategoria: Int): List<Producto?>? //@Query(value = "SELECT * FROM productos WHERE id=?",nativeQuery = true)
    //Optional<Producto> findById(UUID id);
}