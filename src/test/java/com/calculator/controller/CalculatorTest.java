package com.calculator.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class CalculatorTest {

    @DisplayName("입력 값이 null 혹은 빈 문자열인 경우 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void calculatorNullOrEmptyStringTest(final String inputText) {
        Calculator calculator = new Calculator(inputText);
        Integer result = calculator.calculate();
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("입력 값이 숫자 하나인 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1|1", "2|2"}, delimiter = '|')
    void calculatorOneStringTest(final String inputText, final Integer expected) {
        Calculator calculator = new Calculator(inputText);
        Integer result = calculator.calculate();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("쉼표가 포함된 입력 값 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "3,7|10"}, delimiter = '|')
    void calculatorIncludeCommaStringTest(final String inputText, final Integer expected) {
        Calculator calculator = new Calculator(inputText);
        Integer result = calculator.calculate();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("쉼표와 콜론이 포함된 입력 값 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3|6", "2:3,3|8"}, delimiter = '|')
    void calculatorIncludeCommaAndColonStringTest(final String inputText, final Integer expected) {
        Calculator calculator = new Calculator(inputText);
        Integer result = calculator.calculate();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("커스텀한 구분자가 포함된 입력 값 테스트")
    @ParameterizedTest
    @MethodSource("provideDummyString")
    void calculatorIncludeCustomSeparatorStringTest(final String inputText, final Integer expected) {
        Calculator calculator = new Calculator(inputText);
        Integer result = calculator.calculate();
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideDummyString() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//&\n4&5", 9),
                Arguments.of("//#\n2#7", 9)
        );
    }
}
