package com.pollra.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("계산 테스트")
class CalculatorTest {

    @Test
    @DisplayName("\"//;\\\\n1;2;3,4:5:6;7,8:9;10\" 입력 시 55 리턴")
    public void sum() {
        Calculator calculator = new Calculator();
        Number calculateResult = calculator.sum("//;\\\\n1;2;3,4:5:6;7,8:9;10");
        Number expectedResult = new Number(55);

        assertEquals(expectedResult, calculateResult);
    }

    @Test
    @DisplayName("\"//test\\\\n1test2test3,4:5:6test7,8:9test10\" 입력 시 55 리턴")
    public void sum2() {
        Calculator calculator = new Calculator();
        Number calculateResult = calculator.sum("//test\\\\n1test2test3,4:5:6test7,8:9test10");
        Number expectedResult = new Number(55);

        assertEquals(expectedResult, calculateResult);
    }
}