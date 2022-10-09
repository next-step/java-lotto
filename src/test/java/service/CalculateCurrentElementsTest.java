package service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Calculator;
import domain.Divide;
import domain.FindCalculateStrategy;
import domain.Minus;
import domain.Multiply;
import domain.Plus;
import view.InputValidation;
import view.InputView;

class CalculateCurrentElementsTest {

    private FindCalculateStrategy findCalculateStrategy;

    private CalculateCurrentElements calculateCurrentElements;

    List<Calculator> calculatorList = new ArrayList<>();

    Deque<String> pendingElements = new ArrayDeque<>();

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
    }

    @Test
    @DisplayName("계산을 하기위한 조건이 충족된 경우 값을 출력하는지 확인(현재 배열의 길이가 3인 경우)")
    void CalculateCurrentElementsTest() {

        String[] splitInput = {"1", "+", "2"};
        List<String> testElements = Arrays.asList(splitInput);
        String expected = "3";

        pendingElements = calculateCurrentElements.calculateElements(testElements, pendingElements);

        assertThat(pendingElements.poll()).isEqualTo(expected);
    }

}