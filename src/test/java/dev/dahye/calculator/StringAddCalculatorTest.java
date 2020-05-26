package dev.dahye.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("문자열 덧셈 계산기")
class StringAddCalculatorTest {

    @ParameterizedTest(name = "input = \"{0}\"")
    @NullAndEmptySource
    @DisplayName("계산기에 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    void calculateNullOrEmpty(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertEquals(0, result);
    }

    @ParameterizedTest(name = "input = {0}")
    @ValueSource(strings = {"1", "2", "10"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void onlyNumber(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertEquals(Integer.parseInt(input), result);
    }
}