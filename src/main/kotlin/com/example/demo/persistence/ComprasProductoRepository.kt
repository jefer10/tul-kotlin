package com.example.demo.persistence

import com.example.demo.persistence.crud.CompraProductoCrudRepository
import com.example.demo.persistence.entity.ComprasProducto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ComprasProductoRepository {
    @Autowired
    private val compraProductoCrudRepository: CompraProductoCrudRepository? = null

    val all: MutableIterable<ComprasProducto?>
        get() = compraProductoCrudRepository?.findAll() as MutableIterable<ComprasProducto?>

    fun getCompra(compraId: Int): Optional<ComprasProducto?> {
        return compraProductoCrudRepository!!.findById(compraId)
    }

    fun save(comprasProducto: ComprasProducto): ComprasProducto{
        return compraProductoCrudRepository!!.save(comprasProducto)
    }

    fun delete(productId: Int) {
        compraProductoCrudRepository?.deleteById(productId)
    }
}