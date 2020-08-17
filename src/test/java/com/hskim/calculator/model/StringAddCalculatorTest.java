package com.hskim.calculator.model;

import com.hskim.calculator.StringAddCalculator;
import com.hskim.calculator.model.CalculateResult;
import com.hskim.calculator.model.CalculatorNumberTokens;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    private static StringAddCalculator stringAddCalculator = StringAddCalculator.getInstance();

    @DisplayName("calculate() 테스트")
    @ParameterizedTest
    @MethodSource("provideTokenList")
    void calculate(CalculatorNumberTokens calculatorNumberTokens, int expectedSum) {
        // given
        CalculateResult expected = new CalculateResult(expectedSum);

        // when
        CalculateResult result = stringAddCalculator.calculate(calculatorNumberTokens);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTokenList() {
        return Stream.of(
                Arguments.of(new CalculatorNumberTokens(Arrays.asList("3", "5", "7", "9")), 24),
                Arguments.of(new CalculatorNumberTokens(Arrays.asList("2", "4", "6", "8")), 20),
                Arguments.of(new CalculatorNumberTokens(Arrays.asList("1", "2", "3", "4", "5")), 15),
                Arguments.of(new CalculatorNumberTokens(Arrays.asList("7", "50", "300", "2000")), 2357)
        );
    }
}
