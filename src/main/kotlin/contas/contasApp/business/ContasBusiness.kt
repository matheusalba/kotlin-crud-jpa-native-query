package contas.contasApp.business

import contas.contasApp.model.*
import contas.contasApp.repository.RepCodigoEmp
import contas.contasApp.repository.RepContas
import org.springframework.web.bind.annotation.*
import contas.contasApp.repository.RepEmpresas
import contas.contasApp.service.jpaNativeQuery
import java.util.*

@RestController
@RequestMapping("contas")
class ContasBusiness
    (
    val repoEmpre: RepEmpresas,
    val repoContas: RepContas,
    val JNQ: jpaNativeQuery,
    )
{
    @GetMapping("consulta")
    fun consulta(@RequestBody c:ContaDTO){
        JNQ.teste(c)
    }

    @PostMapping("/conta")
    fun salvaConta(@RequestBody c: ContaDTO){
        val emp = repoEmpre.getReferenceById(c.idEmpresa)
        /* jakarta.persistence.EntityNotFoundException -> caso não encontre, tratar o erro */
        if(emp!=null) {
            repoContas.save(Conta(null, emp, c.tipoConta, c.tipoFiscal, c.valor, c.prazoDias, c.credor, c.tipoCredor))
        }
    }

    @PostMapping("/contas/mes")
    fun contasMes(@RequestBody c: MesContaDTO){
        if(validaMesConta(c)){
            preparePacote(c)
        }
    }

    fun validaMesConta(pacote:MesContaDTO):Boolean{
    return true
    }

    fun preparePacote(pacote: MesContaDTO){
        pacote.listaContas.forEach {
            repoContas.inserirMesContas(it.credor,
                it.prazoDias,
                it.tipoConta,
                it.tipoCredor,
                it.tipoFiscal,
                it.valor,
                it.idEmpresa
            )
        }
    }




    companion object{
        val VALOR_NORMAL = 2500.50
    }
    }