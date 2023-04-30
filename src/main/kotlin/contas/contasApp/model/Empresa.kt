package contas.contasApp.model

import jakarta.persistence.*

@Entity
@Table(name="empresas")
class Empresa {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
var id: Long? = null

@Column
var nome: String? = null

@Column
var ramo: String? = null
}