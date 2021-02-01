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

        listObjects.stream().forEach(ob -> {
            //ob.
        });

//        Map<Fruits, IntSummaryStatistics> collect = listObjects.stream()
//                .collect(groupingBy(
//                        fruit -> new Fruits(fruit.type, fruit.char1, fruit.char2),
//                        Collectors.summarizingInt(fruit -> fruit.age)));
//                collect.forEach((k,v) ->{
//                    k.age= (int) v.getSum();
//                    System.out.format(k.age+" "+k.type+": "+k.char1+", "+k.char2+"\n");
//                });




//
//        Comparator<Fruits> compareFruits =Comparator
//                .comparing(Fruits::getType)
//                .thenComparing(Fruits::getChar1)
//                .thenComparing(Fruits::getChar2);
//
//        List<Fruits> sortedFruits =listObjects.stream()
//                .sorted(compareFruits)
//                .collect(Collectors.toList(),
//                        Collectors.counting());
//        System.out.println(sortedFruits);





        //        List<Fruits> newList = new ArrayList<>();
//
//        listObjects.forEach(a -> newList.add(new Fruits(a.getType(),
//                a.getChar1(),
//                a.getChar2())));
//
//
//
//
//        Map<Fruits, Integer> map = newList.stream().
//                collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
//        map.forEach((key, value) -> System.out.println(value + ": " + key.getAge() + ": " + key.getChar1() + ", " + key.getChar2()));
//

        // 1. Set of 3 elements (4 of them)
        // 2. Run list if list has set -> store as map number, set (loop)
//        Set<Fruits> fruitsSet = new HashSet<>();
//
//        listObjects.forEach(fruitObject -> {
//            fruitsSet.add(new Fruits(fruitObject.getType(), fruitObject.getChar1(), fruitObject.getChar2()));
//        });
//
//        fruitsSet.forEach(a -> System.out.println(a.getType() + ", " + a.getChar1() +", " + a.getChar2()));
//        Map<Integer, Set<Fruits>> mapFruits = new HashMap<>();
//
//
//        for (Fruits element : fruitsSet) {
//            int sum = 0;
//
//            for (Fruits fruitObject : listObjects) {
//                if (element.getType().equals(fruitObject.getType()) && element.getChar1().equals(fruitObject.getChar1())
//                && element.getChar2().equals(fruitObject.getChar2())) {
//                    sum++;
//                }
//            }
//            mapFruits.put(sum, fruitsSet);
//
//        }
//        mapFruits.forEach((key, value) -> System.out.println(key + ": " + value));




        // if set has values from the list +1



//        setOfList.forEach(System.out::println);


    }


}
