package contas.contasApp.repository

import contas.contasApp.model.CodigoEmp
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RepCodigoEmp:JpaRepository<CodigoEmp, Long> {
    @Query("""
     select
    emp.nome,
    emp.ramo 
    from codigos_emp ce
    inner join empresas emp on emp.id = ce.id_emp 
    where cast(ce.codigo as integer) = :codigo 
""", nativeQuery = true)
fun consultaCodigo(
    @Param("codigo")codigo:Int
):List<*>


}