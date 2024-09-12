package com.example.demo;

import java.time.LocalDate;

//import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="Expense")
public class Expense {
   @Id
   @GeneratedValue(strategy =GenerationType.IDENTITY)
  private Long id;
   private String name;
   private String category;
   private String description;
   private LocalDate Date;
   private double amount;

}
