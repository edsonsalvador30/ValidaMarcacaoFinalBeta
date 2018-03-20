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
@Repository("BudgetProductDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface BudgetProductDAO extends JpaRepository<BudgetProduct, java.lang.String> {

  /**
   * Obtém a instância de BudgetProduct utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM BudgetProduct entity WHERE entity.id = :id")
  public BudgetProduct findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de BudgetProduct utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM BudgetProduct entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * Foreign Key budget
   * @generated
   */
  @Query("SELECT entity FROM BudgetProduct entity WHERE entity.budget.id = :id")
  public Page<BudgetProduct> findBudgetProductsByBudget(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key product
   * @generated
   */
  @Query("SELECT entity FROM BudgetProduct entity WHERE entity.product.id = :id")
  public Page<BudgetProduct> findBudgetProductsByProduct(@Param(value="id") java.lang.String id, Pageable pageable);

}
