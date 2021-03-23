package com.example.demo.persistence

import com.example.demo.persistence.crud.ProductoCrudRepository
import com.example.demo.persistence.entity.Producto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProductoRepository {
    @Autowired
    private val productoCrudRepository: ProductoCrudRepository? = null
    val all: MutableIterable<Producto?>
        get() = productoCrudRepository!!.findAll()

    fun getProducto(productoId: UUID): Optional<Producto?> {
        return productoCrudRepository!!.findById(productoId)
    }

    fun save(producto: Producto): Producto {
        return productoCrudRepository!!.save(producto)
    }

    fun delete(productId: UUID) {
        productoCrudRepository!!.deleteById(productId)
    }
}