package com.example.demo;
import java.time.LocalDate;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class IncomeService {
 
     @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> AllIncome() {
       return incomeRepository.findAll();
    }

    public Optional<Income> incomeById( Long id){
        return incomeRepository.findById(id);
    }

    public Income AddIncome(Income incomr){
     
       return incomeRepository.save(incomr);
    
    }
    public void deleteIncome(@PathVariable Long id){
        Optional<Income> incc = incomeRepository.findById(id);
        if (incc.isPresent()) {
            incomeRepository.deleteById(id);
        }else{
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somthing went wrong");
        }
             
    }
    public void UpdateIncome(@RequestBody Income income, @PathVariable Long id) {
       Income userr= incomeRepository.findById(id).orElse(null);
       if (userr!=null) {
            userr.setAmount(income.getAmount());
            userr.setCategory(income.getCategory());
            userr.setDescription(income.getDescription());
            userr.setDate(income.getDate());
            incomeRepository.save(userr);
       }else{
         ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        
       }
    }
    public double maxinc(){
       return incomeRepository.MaxIncome();
    }
    public double mininc(){
        return incomeRepository.MinIncome();
     }
     public double totalinc(){
        return incomeRepository.Totalncome();
     }
 
     

     public java.util.List<Chart> CategroyChart(){
        return  incomeRepository.ChartIncome();
     }
     public List<Income> DateRang(LocalDate   startDate, LocalDate endDate){
      return incomeRepository.CustomeIncomeBydate(startDate, endDate);
   }
   public List<Income> incbycat(String category){
        return incomeRepository.listbycate(category);
   }
}
