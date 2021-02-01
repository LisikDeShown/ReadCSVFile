package main.basket;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StartApplication {

    private static final String SEPARATOR = File.separator;

    public static void main(String[] args) throws FileNotFoundException {

        List<Fruits> list= new ArrayList<>();
                    File file = new File("src" + SEPARATOR + "resource" + SEPARATOR + "TestJava.csv");

        Scanner scanner = new Scanner(file);
        Fruits fruits = new Fruits();
        while(scanner.hasNext()){
            String next = scanner.next();
            List<String> list1 = Arrays.asList(next.split(","));
            String type = list1.get(0);
            int age = Integer.parseInt(list1.get(1));
            String charOne = list1.get(2);
            String charTwo = list1.get(3);

            Fruits fruit = new Fruits(type,age,charOne,charTwo);
            list.add(fruit);
        }
        System.out.println("Total number of fruit:\n" + list.size() + "\n");
        System.out.println("Total types of fruit:\n" + new Fruits().totalTypes(list) + "\n");
        System.out.println("Oldest fruit and age:" );
        new Fruits().oldestFruit(list);
        System.out.println("\nThe number of each type of fruit in descending order:");
        fruits.getGroups(list);
        System.out.println("\nThe various characteristics (count, color, shape, etc.) of each fruit by type:");
        fruits.getGroupTypesAndChars(list);
        scanner.close();

    }

}

