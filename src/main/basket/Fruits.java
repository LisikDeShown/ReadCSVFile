package main.basket;

import java.util.List;

public class Fruits {
    String type;
    String age;
    String char1;
    String char2;

    public Fruits(String type, String age, String char1, String char2){
        this.type=type;
        this.age=age;
        this.char1=char1;
        this.char2=char2;
    }

    public Fruits() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
    public String toString() {
        return
                "type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", char1='" + char1 + '\'' +
                ", char2='" + char2;
    }

    public long totalTypes(List<Fruits> list){
        return list.stream().map(listFruits -> listFruits.getType().trim()).distinct().count();
    }

}
