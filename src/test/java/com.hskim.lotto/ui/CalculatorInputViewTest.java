package com.hskim.lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorInputViewTest {

    private static CalculatorInputView calculatorInputView = new CalculatorInputView();

    @DisplayName("makeTokens() 메소드 성공 테스트")
    @ParameterizedTest
    @MethodSource("provideValidInputs")
    void makeTokens_성공_테스트(String input, PositiveNumberExpr expected) {

        // when
        int result = calculatorInputView.makeTokens(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideValidInputs() {

        return Stream.of(
                Arguments.of("1;2;3", Arrays.asList("1", "2", "3")),
                Arguments.of("//&\n5&4&15&3", Arrays.asList("5", "4", "15", "3")),
                Arguments.of("//$\n11$13$7$1", Arrays.asList("11", "13", "7", "1"))
        );
    }
}
