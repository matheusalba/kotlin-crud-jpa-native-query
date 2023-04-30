package contas.contasApp.business

import contas.contasApp.repository.RepCodigoEmp
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("codigo")
class CodigoBusiness (
    val repoCodi: RepCodigoEmp,
        ) {
    @GetMapping("/authemp/{codigo}")
    fun authEmp(@PathVariable codigo:Int){
        val resp = repoCodi.consultaCodigo(codigo)
    }
}