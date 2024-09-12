package com.example.demo;

import lombok.Data;

@Data
public class Chart {
    private String category;
    private double amount;
    public Chart(String category, Double amount) {
        this.category = category;
        this.amount = amount;
    }
}
