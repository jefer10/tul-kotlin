package com.example.demo.domain.service

import com.example.demo.persistence.ProductoRepository
import com.example.demo.persistence.entity.Producto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductoService {
    @Autowired
    private val productoRepository: ProductoRepository? = null
    fun all(): MutableIterable<Producto?> {
        return  productoRepository!!.all
    }

    fun getProducto(productoId: UUID): Optional<Producto> {
        return productoRepository!!.getProducto(productoId).map { producto->producto }
    }

    fun save(producto: Producto): Producto {
        if (producto.descuento == true) {
            producto.precioVenta = producto.precioVenta!! / 2
        }
        return productoRepository!!.save(producto)
    }

    fun update(producto: Producto): Producto {
        val old: Optional<Producto> = getProducto(producto.idProducto!!)
        if (old.get().descuento !== producto.descuento) {
            if (producto.descuento === true) {
                producto.precioVenta = producto.precioVenta!! / 2
            } else {
                producto.precioVenta = producto.precioVenta!! * 2
            }
            return productoRepository!!.save(producto)
        }
        return productoRepository!!.save(producto)
    }

    fun delete(productId: UUID) {
        productoRepository!!.delete(productId)
    }
}