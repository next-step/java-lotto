package com.hskim.lotto.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    private static StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @DisplayName("calculate()메소드 정상 작동 검증")
    @ParameterizedTest
    @MethodSource("provideTokenList")
    void calculate_정상_작동_테스트(List<String> tokenList, int expected) {

        // when
        int result = stringAddCalculator.calculate(tokenList);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private Stream<Arguments> provideTokenList() {

        return Stream.of(
                Arguments.of(Arrays.asList("3", "5", "7", "9"), 24),
                Arguments.of(Arrays.asList("2", "4", "6", "8"), 20),
                Arguments.of(Arrays.asList("1", "2", "3", "4", "5"), 15),
                Arguments.of(Arrays.asList("7", "50", "300", "2000"), 2357)
        );
    }
}
