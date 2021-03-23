package com.example.demo.web.controller

import com.example.demo.domain.service.ComprasProductoService
import com.example.demo.persistence.entity.Compra
import com.example.demo.persistence.entity.ComprasProducto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("carro")
class ComprasProductoController {
    @Autowired
    private val comprasProductoService: ComprasProductoService? = null

    @RequestMapping("/all")
    fun all(): MutableIterable<ComprasProducto?> {
        return comprasProductoService!!.all()
    }

    @RequestMapping("/{id]")
    fun getComprasProductos(@PathVariable("id") id: Int): Optional<ComprasProducto?> {
        return comprasProductoService!!.getCompra(id)
    }

    @PostMapping("/save")
    fun save(@RequestBody comprasProducto: ComprasProducto): ComprasProducto {
        return comprasProductoService!!.save(comprasProducto)
    }

    @PostMapping("/update")
    fun update(@RequestBody comprasProducto: ComprasProducto): ComprasProducto {
        return comprasProductoService!!.save(comprasProducto)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Int) {
        comprasProductoService!!.delete(id)
    }
}