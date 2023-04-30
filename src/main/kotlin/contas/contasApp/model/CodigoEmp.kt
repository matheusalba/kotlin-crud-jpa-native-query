package contas.contasApp.model

import jakarta.persistence.*

@Entity
@Table(name="codigos_emp")
data class CodigoEmp (
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
var id: Long? = null,

@OneToOne
@JoinColumn(name = "id_emp")
var empresa: Empresa,

@Column
var codigo: String? = null
    )