package com.nextlevel.kky.calculator;

import com.nextlevel.kky.calculator.Calculator;
import com.nextlevel.kky.calculator.InputNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2", "2 - 1:1", "4 / 2:2", "3 * 3:9"}, delimiter = ':')
    @DisplayName("기본 사칙연산을 정상적으로 수행한다.")
    public void calculationTest(String expression, int expected) {
        assertThat(calculateResult(expression)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열 값을 입력할 경우 예외가 발생한다.")
    public void nullOrEmptyTest(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculateResult(expression));
    }

    private int calculateResult(String expression) {
        List<String> numbersAndOps = InputNumbers.inputNumbers(expression);
        return new Calculator().calculate(numbersAndOps);
    }
}
