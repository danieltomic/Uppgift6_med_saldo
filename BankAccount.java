package com.company;


public class BankAccount {
    private String nbr;
    private double balance = 0;

    public BankAccount(String nbr, double balance){
        this.nbr = nbr;
        this.balance = balance;
    }

    public void credit(double amount){
        balance = balance + amount;

    }

    public void withdraw(double amount){
        balance = balance - amount;
    }

    public double getBalance(){
        return balance;
    }

    public String getnbr(){
        return nbr;
    }
}
