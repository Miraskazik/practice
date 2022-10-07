package com.test.effectivejava;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise2 {
    public static void main(String[] args) {
//        Write a method to return a list of squares of positive numbers from the list of integers below using the Stream API.

        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

        List<Integer> expectedOutput = Arrays.asList(1, 9, 144, 361, 36, 81, 100, 196);

        System.out.println(squarePositiveNums(numbers));
    }

    public static List<Integer> squarePositiveNums(List<Integer> list){
       List<Integer> plusNums = list.stream().filter(x -> x > 0).toList();
       return plusNums.stream().map(integer -> integer*integer).collect(Collectors.toList());
    }
}
