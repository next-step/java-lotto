package com.hskim.lotto.model;

import com.hskim.lotto.exception.CalculatorException;
import com.hskim.lotto.exception.CalculatorExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumberTokensTest {

    @DisplayName("양수가 아닌 문자열이 포함된 경우 Runtime Exception 발생 테스트")
    @ParameterizedTest
    @MethodSource("provideInvalidInputs")
    void 양수가_아닌_문자열_예외_테스트(List<String> tokenList, CalculatorException expected) {

        // when & then
        assertThatExceptionOfType(CalculatorException.class).isThrownBy(() -> {
            new PositiveNumberTokens(tokenList);
        }).withMessage(expected.getMessage());
    }

    private static Stream<Arguments> provideInvalidInputs() {

        return Stream.of(
                Arguments.of(Arrays.asList("3", "5", "7", "a"), new CalculatorException(CalculatorExceptionType.CONTAINS_NO_NUMERIC)),
                Arguments.of(Arrays.asList("1", "2", "-3"), new CalculatorException(CalculatorExceptionType.CONTAINS_NEGATIVE_NUMERIC))
        );
    }
}
