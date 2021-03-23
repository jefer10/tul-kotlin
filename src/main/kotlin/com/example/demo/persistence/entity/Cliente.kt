package com.example.demo.persistence.entity

import com.example.demo.persistence.entity.Compra
import javax.persistence.*

@Entity
@Table(name = "clientes")
class Cliente {
    @Id
    var id: String? = null
    var nombre: String? = null
    var apellidos: String? = null
    var celular: Long? = null
    var direccion: String? = null

    /*
    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
 */
    @Column(name = "correo_electronico")
    var correoElectronico: String? = null

    @OneToMany(mappedBy = "cliente")
    private val compras: List<Compra>? = null
}