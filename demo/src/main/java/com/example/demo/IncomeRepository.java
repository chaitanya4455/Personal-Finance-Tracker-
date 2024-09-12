package com.example.demo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Long> {

    
    @Query("select max(amount) from Income")
    Double MaxIncome();

    @Query("select min(amount) from Income")
    Double MinIncome();

    @Query("select sum(amount) from Income")
    Double Totalncome();
    @Query("select  category,sum(amount) from Income group by category")
   java.util.List <Chart> ChartIncome();
   @Query("select ei from Income ei where ei.Date between :startDate and :endDate ")
    java.util.List <Income> CustomeIncomeBydate(@Param("startDate") LocalDate starDate, @Param("endDate") LocalDate endDate);

   @Query("select Income from Income where category=:category ")
   java.util.List<Income>listbycate(@Param("category") String category );
    
}
