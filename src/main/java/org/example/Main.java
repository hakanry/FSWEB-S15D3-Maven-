package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // System.out.println(WordCounter.calculatedWord());



        List<Employee> employeeList = new LinkedList<>();

        employeeList.add(new Employee(0,"Hakan","Yalçın"));
        employeeList.add(new Employee(1,"Reşit","Yalçın"));
        employeeList.add(new Employee(4,"Engin","Küpeli"));
        employeeList.add(new Employee(2,"Ali","Haydar"));
        employeeList.add(new Employee(2,"Ali","Haydar"));
        employeeList.add(new Employee(3,"Can","Dört"));
        employeeList.add(new Employee(3,"Can","Dört"));
        employeeList.add(new Employee(3,"Can","Dört"));
        employeeList.add(null);

        System.out.println(employeeList);
        System.out.println("----------------------------------------------------------");

        for(Employee e : employeeList){
            System.out.println(Collections.frequency(employeeList,e));
        }
        System.out.println("----------------------------------------------------------");
        System.out.println(findDuplicates(employeeList));
        System.out.println("----------------------------------------------------------");
        System.out.println(findUniques(employeeList));
        System.out.println("----------------------------------------------------------");
        System.out.println(removeDuplicates(employeeList));
        System.out.println("----------------------------------------------------------");



    }
    public static List<Employee> findDuplicates (List<Employee> employeeListe){
       List<Employee> ayniEmployeeler = new LinkedList<>();
       for(Employee e : employeeListe){
           if(e!= null && Collections.frequency(employeeListe,e) > 1){
               if(!ayniEmployeeler.contains(e)){
                    ayniEmployeeler.add(e);
               }
           }
       }
       return ayniEmployeeler;
    }
    public static Map<Integer,Employee> findUniques (List<Employee> employeeListe){
        Map<Integer,Employee> employeeMap = new HashMap<>();
        for(Employee e : employeeListe){
            if(e!= null && Collections.frequency(employeeListe,e) >= 1){
                employeeMap.put(e.getId(),e);
            }
        }
        return employeeMap;
    }
    public static  List<Employee> removeDuplicates  (List<Employee> employeeListe){
        List<Employee> ayniOlanlar = findDuplicates(employeeListe);
        for(Employee e : ayniOlanlar){
            Iterator<Employee> employeeIterator = employeeListe.iterator();
            while (employeeIterator.hasNext()){
                Employee eleman = employeeIterator.next();
                if(eleman== null || eleman.equals(e)){
                    employeeIterator.remove();
                }
        }

        }
        return employeeListe;
    }
}