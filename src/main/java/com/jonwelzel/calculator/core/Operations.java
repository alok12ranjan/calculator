package com.jonwelzel.calculator.core;


import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class Operations {
    public static BiFunction<Double, Double, Double> add = (x, y) -> x + y;

    public static BiFunction<Double, Double, Double> subtract = (x, y) -> x - y;

    public static BiFunction<Double, Double, Double> divide = (x, y) -> y == 0 ? 0 : x / y;

    public static BiFunction<Double, Double, Double> multiply = (x, y) -> x * y;

}
