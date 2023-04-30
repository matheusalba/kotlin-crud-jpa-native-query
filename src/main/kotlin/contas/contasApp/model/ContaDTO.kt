package contas.contasApp.model

class ContaDTO (
val idEmpresa: Long = 0,
val tipoConta: String = "",
val tipoFiscal: String = "",
val valor: Double = 0.0,
val prazoDias: Int = 0,
val credor: String = "",
val tipoCredor: String = "",
val primeiroAgrupamento: String? = null,
val segundoAgrupamento: String? = null,
val ordenacao: String? = null,
)