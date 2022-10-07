package com.test.effectivejava;

import com.test.effectivejava.pojo.Dog;

import java.math.BigDecimal;
import java.util.List;

public class MainDog {
    public static void main(String[] args) {
        Dog dog1 = Dog.builder()
                .name("Loki")
                .race("Vizsla")
                .age(4)
                .weight(0)
                .build();
        Dog dog2 = Dog.builder()
                .name("Priya")
                .race("Weimaraner")
                .age(6)
                .weight(0.2)
                .build();
        Dog dog3 = Dog.builder()
                .name("Marvin")
                .race("Irish setter")
                .age(1)
                .weight(0.1)
                .build();
        List<Dog> packOfDogs = List.of(dog1,dog2,dog3);

        BigDecimal b1 = BigDecimal.valueOf(dog1.getWeight());
        BigDecimal b2 = BigDecimal.valueOf(dog2.getWeight());
        BigDecimal b3 = BigDecimal.valueOf(dog3.getWeight());
        System.out.println(b1.add(b2).add(b3).doubleValue());
        BigDecimal total = BigDecimal.ZERO;
        for (Dog dog:packOfDogs) {
            total= total.add(BigDecimal.valueOf(dog.getWeight()));
        }
        System.out.println(total);
        dog1.getName().concat("asd");

        for (Dog dog : packOfDogs) {
            System.out.println(dog);
        }
    }

}
