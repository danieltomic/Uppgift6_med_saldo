package com.company;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Person {
    private String pNbr;
    private String name;
    private String statusText;
    private List<BankAccount> myBankAccounts = new ArrayList<>();

    private String nbr;
    double balance;

    public Person(String pNbr, String name) {
        this.pNbr = pNbr;
        this.name = name;
    }

    public int getBankAccounts(){
        return myBankAccounts.size();
    }


    public void addAccount() {

        boolean nbrExists = false;

        nbr = JOptionPane.showInputDialog("Vad vill du ditt konto skall ha för kontonummer?");

        if (nbr == null) {
            statusText = ""; // ifall rutan kryssas ner, inget ska komma upp i textrutan
        } else if (StringUtils.isBlank(nbr)) {
            statusText = "Kan inte mata in blankt värde";

        } else {

            for (int i = 0; i < myBankAccounts.size(); i++) {

                if (myBankAccounts.get(i).getnbr().equals(nbr)) {

                    statusText = "Bankkonto med detta nummer finns redan";
                    nbrExists = true;
                    break;

                } else {
                    nbrExists = false;
                }
            }
            if (nbrExists == false) {
                myBankAccounts.add(new BankAccount(nbr, balance));
                statusText = "Bankkontot har lagts till";
            }
        }


        myBankAccounts.add(new BankAccount(nbr, balance));

}







    public String getpNbr(){
        return pNbr;
    }
    public String getName(){
        return name;
    }
}
