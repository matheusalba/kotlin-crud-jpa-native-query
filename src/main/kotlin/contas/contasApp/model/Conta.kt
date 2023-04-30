package contas.contasApp.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="contas")
data class Conta(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? = null,

    @ManyToOne
    @JoinColumn(name="id_empresa", referencedColumnName = "id")
    var empresa: Empresa? = null,

    @Column
    var tipoConta: String = "",

    @Column
    var tipoFiscal: String = "",

    @Column
    var valor: Double = 0.0,

    @Column
    var prazoDias: Int = 0,

    @Column
    var credor: String = "",

    @Column
    var tipoCredor: String = "",
    )