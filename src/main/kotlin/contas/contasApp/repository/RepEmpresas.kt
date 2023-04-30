package contas.contasApp.repository

import contas.contasApp.model.Empresa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RepEmpresas : JpaRepository<Empresa,Long>{}