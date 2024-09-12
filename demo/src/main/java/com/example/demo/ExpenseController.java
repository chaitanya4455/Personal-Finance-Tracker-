package com.example.demo;

import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/expense")
public class ExpenseController {
    

     @Autowired
     private ExpenseService expenseService;

    @GetMapping("/getAll")
    public java.util.List<Expense> Allusers(){  
        return expenseService.getaAllusers();
    }
   @PostMapping("/create")
   public Expense Create(@RequestBody Expense User){
      return expenseService.creatUser(User);

   } 

   @GetMapping("/Chart2")
    public java.util.List<Chart> getwiseCate(){
        return expenseService.CategroyChart();
    }

   @GetMapping("/Byid/{id}")
   public Optional<Expense> getUserById(@PathVariable Long id){
       return expenseService.getUserById(id);
      
   }
   @DeleteMapping("/delete/{id}")
   public Long deleteUser(@PathVariable Long id){
      return expenseService.delete(id);

   } 
   @GetMapping("/netincome")
   public double totalIncome(){
      return expenseService.getTotalIncome();

   }
   @GetMapping("/max")
   public double maxexpe(){
      return expenseService.MaxIncome();

   }
   @GetMapping("/min")
   public double minexp(){
      return expenseService.MinIncome();

   }
   @GetMapping("/rangedate")
   public java.util.List<Expense> custom(@RequestParam("startDate")LocalDate startDate, @RequestParam("endDate") LocalDate endDate){
        return expenseService.getByDate(startDate, endDate)
;   }
}
