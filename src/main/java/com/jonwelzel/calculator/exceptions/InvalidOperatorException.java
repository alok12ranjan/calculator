package com.jonwelzel.calculator.exceptions;

public class InvalidOperatorException extends Exception {
    public InvalidOperatorException(String operator) {
        super("\"" + operator + "\" is not a valid operator. Try one of these: \"+\", \"-\", \"/\" or \"*\"");
    }
}
