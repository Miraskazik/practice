package com.test.effectivejava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainMovies {

    public static void main(String[] args) throws IOException {
        HashMap<String, Double> movies = new HashMap<>();
        String line;
        int count = 0;
        BigDecimal average = BigDecimal.ZERO;
       try( BufferedReader bufferedReader = new BufferedReader(new FileReader(
                   "src/main/resources/movies.csv"))) {

           // plneni mapy
           while ((line = bufferedReader.readLine()) != null) {
               //preskoceni prvniho radku
               if (count == 0) {
                   count++;
                   continue;
               }
               String[] values = line.split(",", 2);
               String key = values[0];
               Double value = Double.valueOf(values[1]);
               movies.put(key, value);
           }
       }
        count=0;
        //seznam filmu
        for (String s : movies.keySet()) {
             System.out.println(s);
        }
        //vypocet ratingu
        for (Double s : movies.values()) {
            count++;
            average=BigDecimal.valueOf(s).add(average);
        }
        //average rating
        average=average.divide(BigDecimal.valueOf(count),1,RoundingMode.HALF_UP);
        //max rating
        String keyMax = Collections.max(movies.entrySet(), Map.Entry.comparingByValue()).getKey();
        //min rating
        String keyMin = Collections.min(movies.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Average rating movie is: " + average);
        System.out.println("Max rating movie is: " + keyMax);
        System.out.println("Min rating movie is: " + keyMin);

    }
}
