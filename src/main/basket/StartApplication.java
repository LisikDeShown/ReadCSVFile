package main.basket;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StartApplication {

    public static void main(String[] args) throws FileNotFoundException {

        List<Fruits> list= new ArrayList<>();
                    File file = new File("src\\resource\\TestJava.csv");

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

}
