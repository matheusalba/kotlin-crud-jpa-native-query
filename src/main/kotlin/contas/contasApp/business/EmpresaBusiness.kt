package contas.contasApp.business

import contas.contasApp.model.CodigoEmp
import contas.contasApp.model.Empresa
import contas.contasApp.repository.RepCodigoEmp
import contas.contasApp.repository.RepEmpresas
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("empresas")
class EmpresaBusiness (
    val repoEmpre:RepEmpresas,
    val repoCodi:RepCodigoEmp,
        )
{
    @PostMapping("/save")
    fun saveEmp(@RequestBody e: Empresa){
        repoEmpre.save(e)
        repoCodi.save(CodigoEmp(null,e,(Random().nextInt(1000)+1).toString()))
    }
}