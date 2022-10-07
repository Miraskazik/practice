package com.test.effectivejava.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@ToString
public class Movie {
    private String name;
    private BigDecimal rating;
}
