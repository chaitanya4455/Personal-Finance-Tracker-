package com.example.demo;

import java.time.LocalDate;
import java.util.List;

//import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long>{

  @Query("select sum(amount) from Expense")
  Double TotalIncome();
@Query("SELECT new com.example.demo.Chart(i.category, SUM(i.amount)) FROM Expense i GROUP BY i.category")
 java.util.List<Chart> CategoryExpense();

  @Query("select max(amount) from Expense")
  Double MaxExpense();
  
  @Query("select min(amount) from Expense")
  Double MinExpense();

  @Query("select e from Expense e where e.Date between :startDate and :endDate")
  java.util.List<Expense> CustomExpen(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

 /* @Query("select e from Expense e where e.date between :startDate and :endDate")
    List<Expense> findExpensesBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
  /*  java.util.List<User>findBydateBetween(LocalDate StartDate, LocalDate EndDate);
 
      @Query("select min(amount) from user")
    Double MinExpense();




     
    @Query("select  * from user where Date between :StartDate and :EndDate ")
    java.util.List <Income> CustomeIncomeBydate();
*/


}
    

 
 