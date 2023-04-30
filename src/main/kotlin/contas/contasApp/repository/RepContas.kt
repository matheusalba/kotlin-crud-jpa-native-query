package contas.contasApp.repository

import contas.contasApp.model.Conta
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.EntityTransaction
import jakarta.persistence.PersistenceContext
import jakarta.persistence.Tuple
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@PersistenceContext
@Transactional
interface RepContas: CrudRepository<Conta, Long> {

    @Modifying
    @Query(""" insert into contas (credor, prazo_dias, tipo_conta, tipo_credor, tipo_fiscal, valor, id_empresa)
               values(:credor , :prazo_dias, :tipo_conta, :tipo_credor, :tipo_fiscal, :valor, :id_empresa ) """, nativeQuery = true)
    fun inserirMesContas(
        @Param("credor")credor:String,
        @Param("prazo_dias")prazo_dias:Int,
        @Param("tipo_conta")tipo_conta:String,
        @Param("tipo_credor")tipo_credor:String,
        @Param("tipo_fiscal")tipo_fiscal:String,
        @Param("valor")valor:Double,
        @Param("id_empresa")id_empresa:Long
    )

}