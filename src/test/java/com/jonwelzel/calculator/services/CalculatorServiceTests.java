package com.jonwelzel.calculator.services;

import com.jonwelzel.calculator.exceptions.InvalidOperatorException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceTests {

    @Autowired
    CalculatorService calculatorService;

    @Test(expected = InvalidOperatorException.class)
    public void throwsExceptionWhenOperatorIsInvalid() throws InvalidOperatorException {
        final String invalidOperator = "#";

        calculatorService.computeResult(1.00, 2.00, invalidOperator);
    }

    @Test
    public void addTwoNumbers() throws InvalidOperatorException {
        Double result = calculatorService.computeResult(1.00, 1.00, "+");

        assertThat(result).isEqualTo(2.00);
    }

    @Test
    public void subtractTwoNumbers() throws InvalidOperatorException {
        Double result = calculatorService.computeResult(1.00, 1.00, "-");

        assertThat(result).isEqualTo(0.00);
    }

    @Test
    public void multiplyTwoNumbers() throws InvalidOperatorException {
        Double result = calculatorService.computeResult(2.00, 3.00, "*");

        assertThat(result).isEqualTo(6.00);
    }

    @Test
    public void divideTwoNumbers() throws InvalidOperatorException {
        Double result = calculatorService.computeResult(6.00, 2.00, "/");

        assertThat(result).isEqualTo(3.00);
    }

    @Test
    public void divisionByZeroReturnsZero() throws InvalidOperatorException {
        Double result = calculatorService.computeResult(4.00, 0.00, "/");

        assertThat(result).isEqualTo(0.00);
    }
}
