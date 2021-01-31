package com.company;


import java.io.File;

import java.io.FileNotFoundException;
import java.util.*;

public class main {

    public static void main(String[] args) {

        List<Fruits> list= new ArrayList<Fruits>();
        try {
            File file = new File("/Users/DeLisik/Desktop/TestJava.csv");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String next = scanner.next();
                List<String> list1 = Arrays.asList(next.split(","));
                String type = list1.get(0);
                String age = list1.get(1);
                String charOne = list1.get(2);
                String charTwo = list1.get(3);

                Fruits fruit = new Fruits(type,age,charOne,charTwo);
                list.add(fruit);
            }
            System.out.println("Total number of fruits: " + list.size());
            System.out.println("Total types of fruit: " + new Fruits().totalTypes(list));
            scanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }

    }

}

