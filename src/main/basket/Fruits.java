package main.basket;


import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

public class Fruits {
    String type;
    int age;
    String char1;
    String char2;

    public Fruits() {
    }


    public Fruits(String type, String char1, String char2) {
        this.type = type;
        this.char1 = char1;
        this.char2 = char2;
    }

    public Fruits(String type, int age, String char1, String char2){
        this.type=type;
        this.age=age;
        this.char1=char1;
        this.char2=char2;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public String getChar1() {
        return char1;
    }

    public String getChar2() {
        return char2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruits)) return false;
        Fruits fruits = (Fruits) o;
        return Objects.equals(getType(), fruits.getType()) && Objects.equals(getChar1(), fruits.getChar1()) && Objects.equals(getChar2(), fruits.getChar2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getChar1(), getChar2());
    }

    @Override
    public String toString() {
        return  type + ": " +
                char1 + ", " +
                char2;
    }

    public long totalTypes(List<Fruits> list){
        return list.stream().map(listFruits -> listFruits.getType().trim()).distinct().count();
    }

    public void oldestFruit(List<Fruits> list){

        int oldest = list.stream()
                .max(Comparator.comparing(obj -> obj.getAge())).map(obj -> obj.getAge()).get();

        List<Fruits> listFruits = list.stream().filter(fruitObjects -> fruitObjects.getAge() == oldest).collect(Collectors.toList());

        listFruits.forEach(objectFruits -> System.out.println(objectFruits.getType() + " " + objectFruits.getAge()));
    }

    public void getGroups (List<Fruits> listObjects) {
        Map<String, Long> getGroups = listObjects.stream()
                .collect(groupingBy(Fruits::getType, Collectors.counting()));

        getGroups.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void getGroupTypesAndChars (List<Fruits> listObjects) {

        LinkedHashMap<Object, Long> sortedMap=new LinkedHashMap<>();
        Map<Object, Long> collect = listObjects.stream()
                .collect(groupingBy(
                        fruit -> new Fruits(fruit.type, fruit.char1, fruit.char2),
                        Collectors.counting()));

        collect.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        sortedMap.forEach((k,v) -> System.out.print(v+" "+k+"\n"));
    }
}
