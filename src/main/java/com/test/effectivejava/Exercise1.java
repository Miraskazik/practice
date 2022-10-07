package com.test.effectivejava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise1 {
    public static void main(String[] args) {
//        Write a method to return a list of even numbers from the list of integers below using the Stream API.

        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

        List<Integer> expectedOutput = Arrays.asList(-2, -4, -8, 12, 6, 10, 14);
        returnEvenNumbers(numbers).forEach(System.out::println);
        System.out.println(returnMax(numbers));
        System.out.println(returnMin(numbers));
        System.out.println(returnSUM(numbers));
    }

    private static List<Integer> returnEvenNumbers(List<Integer> list){
        return list.stream().filter(x->x%2==0).collect(Collectors.toList());
    }

    private static Optional<Integer> returnMin(List<Integer> list){
        return list.stream().sorted().findFirst();
    }

    private static Optional<Integer> returnMax(List<Integer> list){
        return list.stream().max(Comparator.naturalOrder());
    }

    private static Optional<Integer> returnSUM(List<Integer> list){
        return list.stream().reduce(Integer::sum);
    }
}
