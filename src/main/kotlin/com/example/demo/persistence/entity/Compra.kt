package com.example.demo.persistence.entity

import org.hibernate.annotations.GenericGenerator
import java.util.UUID
import java.time.LocalDateTime
import com.example.demo.persistence.entity.Estado
import com.example.demo.persistence.entity.Cliente
import com.example.demo.persistence.entity.ComprasProducto
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

@Entity
@Table(name = "compras")
class Compra {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_compra")
    var idCompra: UUID? = null

    @Column(name = "id_cliente")
    var idCliente: @NotNull(message = "Debes especificar el id del cliente") String? = null
    var fecha: LocalDateTime? = null

    @Column(name = "medio_pago")
    var medioPago: @Pattern(regexp = "(E|T)") String? = null
    var comentario: @NotNull(message = "Debes especificar el comentario de la compra") String? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    var estado: Estado? = null
    var total: Double? = null

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private val cliente: Cliente? = null

    /*
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
*/
    //@ElementCollection
    @OneToMany(mappedBy = "compra")
    var productos: List<ComprasProducto>? = null
    override fun toString(): String {
        return "Compra{" +
                "idCompra=" + idCompra +
                ", idCliente='" + idCliente + '\'' +
                ", fecha=" + fecha +
                ", medioPago='" + medioPago + '\'' +
                ", comentario='" + comentario + '\'' +
                ", estado=" + estado +
                ", total=" + total +
                ", cliente=" + cliente +
                ", comprasProductos=" + productos +
                '}'
    }
}