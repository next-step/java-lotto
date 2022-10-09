package service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Calculator;
import domain.Divide;
import domain.FindCalculateStrategy;
import domain.InputValues;
import domain.Minus;
import domain.Multiply;
import domain.Plus;
import view.InputValidation;
import view.InputView;

class CalculateTest {

    private FindCalculateStrategy findCalculateStrategy;

    private CalculateCurrentElements calculateCurrentElements;

    private Calculate calculate;

    List<Calculator> calculatorList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Plus plus = new Plus();
        Divide divide = new Divide();
        Minus minus = new Minus();
        Multiply multiply = new Multiply();

        calculatorList.add(plus);
        calculatorList.add(divide);
        calculatorList.add(minus);
        calculatorList.add(multiply);

        findCalculateStrategy = new FindCalculateStrategy(calculatorList);
        calculateCurrentElements = new CalculateCurrentElements(findCalculateStrategy);
        calculate = new Calculate();
    }

    @Test
    @DisplayName("입력된 값이 원하는 기대값으로 출력되는지 확인")
    void calculateTest() {
        String[] splitInput = {"1", "+", "2"};
        String expected = "3";

        InputValues inputValues = new InputValues(splitInput);
        String result = calculate.calculateInputValue(inputValues, calculateCurrentElements);
        System.out.println(result);

        assertThat(result).isEqualTo(expected);
    }

}