package com.jonwelzel.calculator.core;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class OperationsTests {

    @Test
    public void addTwoNumbers() {
        Double result = Operations.add.apply(1.00, 1.00);

        assertThat(result).isEqualTo(2.00);
    }

    @Test
    public void subtractTwoNumbers() {
        Double result = Operations.subtract.apply(2.00, 1.00);

        assertThat(result).isEqualTo(1.00);
    }

    @Test
    public void divideTwoNumbers() {
        Double result = Operations.divide.apply(4.00, 2.00);

        assertThat(result).isEqualTo(2.00);
    }

    @Test
    public void divisionByZeroReturnsZero() {
        Double result = Operations.divide.apply(4.00, 0.00);

        assertThat(result).isEqualTo(0.00);
    }

    @Test
    public void multiplyTwoNumbers() {
        Double result = Operations.multiply.apply(2.00, 3.00);

        assertThat(result).isEqualTo(6.00);
    }
}
