package com.example.demo.persistence.entity

import java.util.UUID
import com.example.demo.persistence.entity.Compra
import com.example.demo.persistence.entity.Producto
import javax.persistence.*

@Entity
@Table(name = "compras_productos")
class ComprasProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compras_productos")
    var id: Int? = null
    var id_compra: UUID? = null
    var id_producto: UUID? = null
    var cantidad: Int? = null
    var total: Double? = null
    var estado: Boolean? = null

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private var compra: Compra? = null

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    var producto: Producto? = null
    fun setCompra(compra: Compra?) {
        this.compra = compra
    }

    override fun toString(): String {
        return "ComprasProducto{" +
                "id=" + id +
                ", id_compra=" + id_compra +
                ", id_producto=" + id_producto +
                ", cantidad=" + cantidad +
                ", total=" + total +
                ", estado=" + estado +
                ", compra=" + compra +
                ", producto=" + producto +
                '}'
    }
}