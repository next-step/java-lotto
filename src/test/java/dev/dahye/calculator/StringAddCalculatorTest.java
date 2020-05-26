package dev.dahye.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest(name = "input = {0}")
    @CsvSource({"'1,2', 3", "'2,4', 6", "'10,1000', 1010"})
    @DisplayName("구분자가 쉼표인 경우 덧셈 계산")
    void separator_쉼표(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);
        assertEquals(expected, result);
    }
}