package com.hskim.calculator.model;

import com.hskim.calculator.exception.CalculatorException;
import com.hskim.calculator.exception.CalculatorExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CalculatorNumberTokensTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        List<String> tokens = Collections.singletonList("930917");
        CalculatorNumberTokens calculatorNumberTokens = new CalculatorNumberTokens(tokens);

        // when & then
        assertThat(calculatorNumberTokens).isEqualTo(new CalculatorNumberTokens(tokens));
    }

    @DisplayName("양수가 아닌 문자열이 포함된 경우 Runtime Exception 발생 테스트")
    @ParameterizedTest
    @MethodSource("provideInvalidInputs")
    void 양수가_아닌_문자열_예외_테스트(UserInput userInput, CalculatorException expected) {
        // when & then
        assertThatExceptionOfType(CalculatorException.class).isThrownBy(() -> {
            CalculatorNumberTokens.of(userInput);
        }).withMessage(expected.getMessage());
    }

    private static Stream<Arguments> provideInvalidInputs() {
        return Stream.of(
                Arguments.of(new UserInput("3:5:7:a"), new CalculatorException(CalculatorExceptionType.CONTAINS_NO_NUMERIC)),
                Arguments.of(new UserInput("1:2:-3"), new CalculatorException(CalculatorExceptionType.CONTAINS_NEGATIVE_NUMERIC))
        );
    }

    @DisplayName("getSum() 테스트")
    @Test
    void getSum() {
        // given
        UserInput userInput = new UserInput("100:200:300");
        CalculatorNumberTokens calculatorNumberTokens = CalculatorNumberTokens.of(userInput);
        int expected = 600;

        // when
        int result = calculatorNumberTokens.getSum();

        // then
        assertThat(result).isEqualTo(expected);

    }
}
