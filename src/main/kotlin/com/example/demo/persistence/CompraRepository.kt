package com.example.demo.persistence

import com.example.demo.persistence.crud.CompraCrudRepository
import com.example.demo.persistence.entity.Compra

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CompraRepository {
    @Autowired
    private val compraCrudRepository: CompraCrudRepository? = null
    val all: MutableIterable<Compra?>?
        get() = compraCrudRepository?.findAll()

    fun getCompra(compraId: UUID): Optional<Compra?> {
        return compraCrudRepository?.findById(compraId)!!
    }

    fun save(compra: Compra): Compra {
        return compraCrudRepository!!.save(compra)
    }

    fun delete(productId: UUID?) {
        productId?.let { compraCrudRepository?.deleteById(it) }
    }
}