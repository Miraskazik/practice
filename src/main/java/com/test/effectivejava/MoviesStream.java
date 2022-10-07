package com.test.effectivejava;

import com.test.effectivejava.pojo.Movie;

import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MoviesStream {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/movies.csv");
        List<Movie> movies;
        movies = Files.readAllLines(path).stream()
                .skip(1)
                .map(x -> x.split(","))
                .map(a-> Movie.builder()
                        .name(a[0])
                        .rating(new BigDecimal(a[1]))
                        .build())
                .collect(Collectors.toList());

        movies.forEach(System.out::println);
        System.out.println("xxxxxxxxxxx");

        Optional<BigDecimal> averageRating = Optional.of(movies.stream()
                .map(Movie::getRating)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(BigDecimal.valueOf(movies.size()), 1, RoundingMode.HALF_UP));
        System.out.print("Average rating of movies is: ");
        averageRating.ifPresent(System.out::println);

//        Optional<Movie> bestMovie = movies.stream().max(Comparator.comparing(Movie::getRating));
//        Optional<Movie> worstMovie = movies.stream().min(Comparator.comparing(Movie::getRating));
//        System.out.print("Worst rating movie is: ");
//        worstMovie.ifPresent(System.out::println);
//        System.out.print("Best rating movie is: ");
//        bestMovie.ifPresent(System.out::println);

        System.out.println("xxxxxxxxxxx");
        movies.stream().max(Comparator.comparing(Movie::getRating)).ifPresent(System.out::println);
        movies.stream().min(Comparator.comparing(Movie::getRating)).ifPresent(System.out::println);


    }
}
