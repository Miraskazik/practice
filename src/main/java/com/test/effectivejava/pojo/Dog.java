package com.test.effectivejava.pojo;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
public class Dog {
    String name;
    String race;
    int age;
    double weight;
}
