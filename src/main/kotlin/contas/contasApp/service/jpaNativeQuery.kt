package contas.contasApp.service

import contas.contasApp.model.ContaDTO
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Service

@Service
class jpaNativeQuery(
    val em : EntityManager
) {
fun teste(c:ContaDTO): List<Any?> {
    val q = em.createNativeQuery(
        """select 
            c.tipo_conta,
            c.tipo_credor,
            c.valor
            from
            contas c
            order by
            ${ c.primeiroAgrupamento.let { if(it=="A"){"c.tipo_conta"}else{"c.tipo_fiscal"} } } """
    )
    return q.resultList.toList()
}


}