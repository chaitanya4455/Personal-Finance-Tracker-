package com.example.demo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    
    @Autowired
    ExpenseRepository expenseRepository;

     public Expense creatUser(Expense User){/*WE are creating a new expense */
         return   expenseRepository.save(User);
     }
     
     public List<Expense> getaAllusers(){  /*Get All expenses */
            return expenseRepository.findAll();
            /* .stream()
            .sorted(Comparator.comparing(Expense::getDate).reversed())
            .collect(Collectors.toList());*/
     }
 
   /*  public Optional<User> getusersbyId( Long id){
        return userRepository.findById(id);
  }*/
  public Optional< Expense> getUserById(Long id){
       return expenseRepository.findById(id);
  }    
  public void updatUser(Expense User,Long id){  
      /*Update Expense */
      try{
        Expense Userr = expenseRepository.findById(id).orElse(null);
        if (User !=null) {
        Userr.setName(User.getName());
       Userr.setAmount(User.getAmount());
       Userr.setCategory(User.getCategory());
       Userr.setDate(User.getDate());
       Userr.setDescription(User.getDescription());
      //  Userr.setPassword(User.setPassword());
        }
      expenseRepository.save(Userr);
      }catch(Exception e){
           System.out.println("Error has occured"+e);
      }

  }
  public Long delete(Long id){
     Optional    <Expense >use=   expenseRepository.findById(id);
      if (use !=null) {
         expenseRepository.deleteById(id);
      }
        return id;
           
         
     }
public double getTotalIncome(){
     return expenseRepository.TotalIncome();
}
public double MaxIncome(){
     return expenseRepository.MaxExpense();
}
public double MinIncome(){
     return expenseRepository.MinExpense();
}
public List < Chart> CategroyChart(){
     return expenseRepository.CategoryExpense();
}
public double ex(){
     return expenseRepository.MinExpense();
}
public java.util.List<Expense>getByDate(LocalDate startDate,LocalDate endDate){
     return expenseRepository.CustomExpen(startDate,endDate);
}
}
