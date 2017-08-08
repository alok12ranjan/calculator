package com.jonwelzel.calculator.controllers;

import com.jonwelzel.calculator.exceptions.InvalidOperatorException;
import com.jonwelzel.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @RequestMapping(value = "/rest/calculator", method = RequestMethod.GET)
    ResponseEntity<String> calculateResult(
            @RequestParam(name = "firstNumber") Double firstNumber,
            @RequestParam(name = "secondNumber") Double secondNumber,
            @RequestParam(name = "operator") String operator
    ) {
        try {
            return ResponseEntity.ok().body(calculatorService.computeResult(firstNumber, secondNumber, operator).toString());
        } catch (InvalidOperatorException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
