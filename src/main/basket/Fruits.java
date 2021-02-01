package main.basket;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

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

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getChar1() {
        return char1;
    }

    public void setChar1(String char1) {
        this.char1 = char1;
    }

    public String getChar2() {
        return char2;
    }

    public void setChar2(String char2) {
        this.char2 = char2;
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
        return "Fruits{" +
                "type='" + type + '\'' +
                ", char1='" + char1 + '\'' +
                ", char2='" + char2 + '\'' +
                '}';
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

        getGroups.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public void getGroupTypesAndChars (List<Fruits> listObjects) {

        listObjects.forEach(System.out::println);
        Set<Fruits>set = new HashSet<>(listObjects);

        System.out.println(listObjects.size());
        System.out.println(set.size());
        List<List<Fruits>> listOfList = new ArrayList<>();


        for(Fruits objectList : listObjects){
            for (Fruits objectSet : set) {
                if(objectList.equals(objectSet)) {
                    listOfList.add(new ArrayList<>(set));
                }
            }
        }

        Map<List<Fruits>, Integer> collect = listOfList.stream().collect(groupingBy(x -> x, summingInt(x -> 1)));
        collect.forEach((k, v) -> System.out.println(k + ": "));

    }


}
