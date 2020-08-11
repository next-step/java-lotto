package com.hskim.lotto.model;


import com.hskim.lotto.exception.CalculatorException;
import com.hskim.lotto.exception.CalculatorExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumberExprTest {

    private PositiveNumberExpr positiveNumberExpr;


    @DisplayName("빈문자열 혹은 null이 들어오는 경우 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideEmptyInputs")
    void empty_또는_null_생성_테스트(String input) {

        // when
        PositiveNumberExpr positiveNumberExpr = new PositiveNumberExpr(input);

        // then
        assertThat(positiveNumberExpr.getTokenList()).isEqualTo(Arrays.asList("0"));
    }

    private static Stream<String> provideEmptyInputs() {

        return Stream.of(
                "",
                null
        );
    }

    @DisplayName("custom delimiter가 포함된 문자열이 들어오는 경우 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideCustomInputs")
    void custom_delimiter_포함문자열_생성_테스트(String input, List<String> expected) {

        // when
        PositiveNumberExpr positiveNumberExpr = new PositiveNumberExpr(input);

        // then
        assertThat(positiveNumberExpr.getTokenList()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCustomInputs() {

        return Stream.of(
                Arguments.of("//#\n3#5#7#9", Arrays.asList("3", "5", "7", "9")),
                Arguments.of("//;\n1;2;3", Arrays.asList("1", "2", "3")),
                Arguments.of("//@\n2@4@6@8", Arrays.asList("2", "4", "6", "8"))
        );
    }

    @DisplayName("custom delimiter가 포함되지 않은 문자열이 들어오는 경우 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideNormalInputs")
    void custom_delimiter_미포함문자열_생성_테스트(String input, List<String> expected) {

        // when
        PositiveNumberExpr positiveNumberExpr = new PositiveNumberExpr(input);

        // then
        assertThat(positiveNumberExpr.getTokenList()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNormalInputs() {

        return Stream.of(
                Arguments.of("3,5,7,9", Arrays.asList("3", "5", "7", "9")),
                Arguments.of("1;2;3", Arrays.asList("1", "2", "3")),
                Arguments.of("2,4;6,8", Arrays.asList("2", "4", "6", "8")),
                Arguments.of("1", Collections.singletonList("1"))
        );
    }

    @DisplayName("양수가 아닌 문자열이 포함된 경우 Runtime Exception 발생 테스트")
    @ParameterizedTest
    @MethodSource("provideInvalidInputs")
    void 양수가_아닌_문자열_예외_테스트(String input, CalculatorException expected) {

        // when & then
        assertThatExceptionOfType(CalculatorException.class).isThrownBy(() -> {
            new PositiveNumberExpr(input);
        }).withMessage(expected.getMessage());
    }

    private static Stream<Arguments> provideInvalidInputs() {

        return Stream.of(
                Arguments.of("3,5,7,a", new CalculatorException(CalculatorExceptionType.CONTAINS_NO_NUMERIC)),
                Arguments.of("//;\n1;2;-3", new CalculatorException(CalculatorExceptionType.CONTAINS_NEGATIVE_NUMERIC))
                );
    }
}
