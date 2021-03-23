package com.example.demo.domain.service

import com.example.demo.persistence.CompraRepository
import com.example.demo.persistence.entity.Compra
import com.example.demo.persistence.entity.ComprasProducto
import com.example.demo.persistence.entity.Estado
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Function

@Service
class CompraService {

    @Autowired
    private val compraRepository: CompraRepository? = null
    val all: MutableIterable<Compra?>?
        get() {
            return compraRepository?.all
        }

    fun getCompra(compraId: UUID): Optional<Compra?> {
        return compraRepository!!.getCompra(compraId)
    }

    fun save(compra: Compra): Compra {
        compra.estado = Estado.PENDIENTE
        return compraRepository?.save(compra)!!
    }

    fun delete(productId: UUID) {
        compraRepository?.delete(productId)
    }

    fun checkout(compraId: UUID): Compra {
        val compraFinal: Optional<Compra> =getCompra(compraId).map { compra->compra }
        compraFinal.map(Function<Compra, Any> { compra: Compra ->
            val comprasProductos: List<ComprasProducto>? = compra.productos
            var totalf = 0.0
            for (comprasProducto in comprasProductos!!) {
                val total: Double = comprasProducto.total!!
                totalf += total
            }
            compra.total = totalf
            compra
        })
        compraFinal.get().estado = Estado.COMPLETADO
        return compraRepository?.save(compraFinal.get())!!
    }
}