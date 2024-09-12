package com.example.demo;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/income")
public class IncomeController {
    
   @Autowired
   private IncomeService incomeService;
    @GetMapping("/allIncome")
    public List <Income>getAllIncome(){
     
   
       return incomeService.AllIncome();
      
    }
    @GetMapping("/byId/{id}")
    public Optional<Income> incomeById(@PathVariable Long id){
        System.out.println("Successful");
           
            return incomeService.incomeById(id);

    }
    @PostMapping("/create")
    public Income createIncome(@RequestBody Income incomr){
        return incomeService.AddIncome(incomr);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteIncome(@PathVariable Long id){
        
         incomeService.deleteIncome(id);
          
    }
    @PutMapping("/update/{id}")
    public void updateIncome(@RequestBody Income income , Long id){
         incomeService.UpdateIncome(income,id);
    }
    @GetMapping("/max")
    public double maxIncomme(){
        System.out.println("Successful");
           
            return incomeService.maxinc();

    }
    @GetMapping("/min")
    public double mininncomme(){
        System.out.println("Successful");
           
            return incomeService.mininc();

    }
    @GetMapping("/total")
    public double totaleein(){
        System.out.println("Successful");
           
            return incomeService.totalinc();

    }
    @GetMapping("/Chart1")
    public List<Chart> getwiseCate(){
        return incomeService.CategroyChart();
    }

    @GetMapping("/DateRange")
    public List<Income> custoom(@RequestParam("startDate") LocalDate starDate,@RequestParam("endDate") LocalDate endDate){
       return   incomeService.DateRang(starDate,endDate);
    }
    @GetMapping("/category")
    public List<Income> categ(@RequestParam("Category") String category){
           return incomeService.incbycat(category);
    }
}   
