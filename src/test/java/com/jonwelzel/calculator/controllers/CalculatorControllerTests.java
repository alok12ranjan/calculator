package com.jonwelzel.calculator.controllers;

import com.jonwelzel.calculator.services.CalculatorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void addTwoNumbers() throws Exception {
        final String queryParams = "?firstNumber=2&secondNumber=3&operator=+";
        given(this.calculatorService.computeResult(2.00, 3.00, "+")).willReturn(5.00);

        this.mvc.perform(get("/rest/calculator" + queryParams)).andExpect(status().isOk()).andExpect(content().string("5.0"));
    }

}
