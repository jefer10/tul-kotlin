package com.example.demo.domain.service

import com.example.demo.persistence.ComprasProductoRepository
import com.example.demo.persistence.entity.ComprasProducto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ComprasProductoService {
    @Autowired
    private val comprasProductoRepository: ComprasProductoRepository? = null

    fun all(): MutableIterable<ComprasProducto?>{
        return  comprasProductoRepository?.all!!
    }

    fun getCompra(compraId: Int): Optional<ComprasProducto?> {
        return comprasProductoRepository!!.getCompra(compraId)
    }

    fun save(comprasProducto: ComprasProducto): ComprasProducto {
        if (comprasProducto.producto != null) {

            comprasProducto.total = comprasProducto.cantidad!! * comprasProducto.producto!!.precioVenta!!
        }
        return comprasProductoRepository!!.save(comprasProducto)
    }

    fun delete(productId: Int) {
        comprasProductoRepository!!.delete(productId)
    }
}