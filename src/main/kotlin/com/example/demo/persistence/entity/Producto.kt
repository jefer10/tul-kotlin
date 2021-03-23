package com.example.demo.persistence.entity

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import com.example.demo.persistence.entity.ComprasProducto
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "productos")
class Producto {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_producto")
    var idProducto: UUID? = null
    var nombre: @NotNull(message = "Debes especificar el nombre del producto") String? = null

    @Column(name = "codigo_barras")
    var codigoBarras: @NotNull(message = "Debes especificar el nombre") String? = null
        get() = field
        set(sku) {
            field = sku
        }

    @Column(name = "precio")
    var precioVenta: @NotNull(message = "Debes especificar el precio") Double? = null

    @OneToMany(mappedBy = "producto")
    private val comprasProducto: List<ComprasProducto>? = null
    var descuento: @NotNull(message = "Debes especificar si esta en descuento") Boolean? = null
    var descripcion: String? = null
}