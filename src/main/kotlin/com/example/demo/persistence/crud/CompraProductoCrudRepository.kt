package com.example.demo.persistence.crud

import com.example.demo.persistence.entity.ComprasProducto

import org.springframework.data.repository.CrudRepository

interface CompraProductoCrudRepository : CrudRepository<ComprasProducto?, Int?>