    package main.basket;

    import java.io.File;
    import java.io.FileNotFoundException;
    import java.util.*;

    public class StartApplication {

        public static void main(String[] args) throws FileNotFoundException {
            System.out.println("Enter path to the CSV File");

            Scanner sc = new Scanner(System.in);

            String path = sc.next();


            List<Fruits> list = new ArrayList<>();

            try {
                File file = new File(path);

                Scanner scanner = new Scanner(file);

                Fruits fruits = new Fruits();
                while (scanner.hasNext()) {
                    String next = scanner.next();
                    List<String> list1 = Arrays.asList(next.split(","));
                    String type = list1.get(0);
                    int age = Integer.parseInt(list1.get(1));
                    String charOne = list1.get(2);
                    String charTwo = list1.get(3);

                    Fruits fruit = new Fruits(type, age, charOne, charTwo);
                    list.add(fruit);
                }
                System.out.println("\nTotal count of all fruits in the CSV-file: \n" + list.size() + "\n");
                System.out.println("Total count of distinct fruit types  in the basket: \n" + new Fruits().totalTypes(list) + "\n");
                System.out.println("The fruit type and age of the oldest fruit in the basket  in days:");
                new Fruits().oldestFruit(list);

                System.out.println("\nCount of all fruits grouped by fruit types in descending order:");
                fruits.getGroups(list);
                System.out.println("\nCount of all fruits grouped by fruit type and all characteristics in descending order:");
                fruits.getGroupTypesAndChars(list);
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("The CSV file was not found or file does not exist: " + path);
            }
        }
    }


