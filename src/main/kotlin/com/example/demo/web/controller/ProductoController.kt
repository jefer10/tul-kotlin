package com.example.demo.web.controller

import com.example.demo.domain.service.ProductoService
import com.example.demo.persistence.entity.Producto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/productos")
class ProductoController {
    @Autowired
    private val productoService: ProductoService? = null

    @RequestMapping("/all")
    fun all():MutableIterable<Producto?> {
        return  productoService!!.all()
    }

    @PostMapping("/save")
    fun save(@RequestBody producto: @Valid Producto): Producto {
        return productoService!!.save(producto)
    }

    @PostMapping("/update")
    fun update(@RequestBody producto: @Valid Producto): Producto {
        return productoService!!.save(producto)
    }

    @GetMapping("/{id}")
    fun getProducto(@PathVariable("id") id: UUID): Optional<Producto> {
        return productoService!!.getProducto(id)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: UUID) {
        productoService!!.delete(id)
    }
}