package com.example.demo.web.controller

import com.example.demo.domain.service.CompraService
import com.example.demo.persistence.entity.Compra
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/compras")
class ComprasController {
    @Autowired
    private val compraService: CompraService? = null

    @RequestMapping("/all")
    fun all():MutableIterable<Compra?>{
        return compraService!!.all!!
    }


    @PostMapping("/save")
    fun save(@RequestBody compra: @Valid Compra): Compra {
        return compraService!!.save(compra)
    }

    @PostMapping("/update")
    fun update(@RequestBody compra: @Valid Compra): Compra {
        return compraService!!.save(compra)
    }

    @RequestMapping("/checkout/{id}")
    fun checkout(@PathVariable("id") id: UUID): Compra {
        return compraService!!.checkout(id)
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: UUID) {
        compraService!!.delete(id)
    }

    @RequestMapping("/hola")
    fun hola(): String {
        return "hola"
    }
}