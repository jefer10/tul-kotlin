package com.example.demo.persistence.crud

import com.example.demo.persistence.entity.Compra
import com.example.demo.persistence.entity.Producto
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface CompraCrudRepository : CrudRepository<Compra?, UUID?> {
    @Query(value = "SELECT * FROM productos INNER JOIN compras_productos ON productos.id_producto=compras_productos.id_producto WHERE id_compra=?", nativeQuery = true)
    fun getProductoByCompra(id_compra: Int): List<Producto?>?
}