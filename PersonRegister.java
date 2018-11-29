package com.company;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRegister {
    private String name;
    private String pNbr;
    private String statusText;
    private List<Person> personList = new ArrayList<>();

    public void addPerson() {

        System.out.println(getSizeOfList()); // koll på hur många personer som finns i listan för testing

        name = JOptionPane.showInputDialog("Namn");

        boolean pNbrExists = false;

        if (name == null) {
            statusText = "";  // ifall rutan kryssas ner, inget ska komma upp i textrutan

        } else if (StringUtils.isBlank(name)) {
            statusText = "Kan inte mata in blankt värde";
        }

            else{
            pNbr = JOptionPane.showInputDialog("Personnummer");

            if (StringUtils.isBlank(pNbr)) {
                statusText = "Kan inte mata in blankt värde";

            } else if (pNbr == null) {
                statusText = "";
            } else {

                for (int i = 0; i < personList.size(); i++) {

                    if (personList.get(i).getpNbr().equals(pNbr)) {

                        statusText = "Personnummret finns redan i registret";
                        pNbrExists = true;
                        break;

                    } else {
                        pNbrExists = false;
                    }
                }
                if (pNbrExists == false) {
                    personList.add(new Person(pNbr, name));
                    statusText = "Personen har lagts till i registret";
                }
            }
        }
    }

    public Person removePerson() {
        Person getPerson = findPerson();

        if (getPerson != null)
            personList.remove(getPerson);
            statusText = "Personen har tagits bort från registret";
            return null;

    }

        public Person findPerson() {
            Person temp = null;
            pNbr = JOptionPane.showInputDialog("Personens personnummer");

            if (pNbr == null) {
                statusText = "";   //ifall rutan kryssas ner, inget statement
            } else if (StringUtils.isBlank(pNbr)) {
                statusText = "Du kan inte lämna fältet blankt";
            }

            for (int i = 0; i < personList.size(); i++) {
                if (personList.get(i).getpNbr().equals(pNbr)) {
                    temp = getPerson(i);
                    statusText = temp.getName();
                    return temp;
                }
            }
            if (temp == null){
                statusText = "Hittade inte personen";
            }
        return null;
    }

    public Person getPerson(int i){
        return personList.get(i);
    }

    public int getSizeOfList() {
        return personList.size();
    }

    public String getStatusText(){
        return statusText;
    }
}

