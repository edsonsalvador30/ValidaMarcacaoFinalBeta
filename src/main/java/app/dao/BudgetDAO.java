package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 


/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("BudgetDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface BudgetDAO extends JpaRepository<Budget, java.lang.String> {

  /**
   * Obtém a instância de Budget utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Budget entity WHERE entity.id = :id")
  public Budget findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Budget utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Budget entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM BudgetProduct entity WHERE entity.budget.id = :id")
  public Page<BudgetProduct> findBudgetProduct(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key budgetStatus
   * @generated
   */
  @Query("SELECT entity FROM Budget entity WHERE entity.budgetStatus.id = :id")
  public Page<Budget> findBudgetsByBudgetStatus(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key supplier
   * @generated
   */
  @Query("SELECT entity FROM Budget entity WHERE entity.supplier.id = :id")
  public Page<Budget> findBudgetsBySupplier(@Param(value="id") java.lang.String id, Pageable pageable);

}
