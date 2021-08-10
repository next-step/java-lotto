package com.lotto.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberCalculatorTest {
    @DisplayName("숫자 합계 테스트")
    @ParameterizedTest
    @CsvSource({"'1,2,3,4', 10", "'//;\n1;2;3;4', 10", "'//;\n1;2:3', 6", "'//;\n0;1:2,3', 6"})
    public void sum(String input, int expected) {
        //when
        int result = NumberCalculator.sum(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("null 값 넘길 시 테스트")
    @Test
    public void nullInput() {
        //given
        String input = null;

        //when
        int result = NumberCalculator.sum(input);

        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("빈값 넘길 시 테스트")
    @Test
    public void emptyInput() {
        //given
        String input = "";

        //when
        int result = NumberCalculator.sum(input);

        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("유효하지 않은 값 넘길 시 테스트")
    @ParameterizedTest
    @CsvSource({"'1:-1:2', -1", "'1:a:2', a", "'//;\n1;-2;3;4', -2", "'//;\n1;a;3;4', a"})
    public void invalidInput(String input, String expected) {
        //then
        assertThatThrownBy(() -> {
            NumberCalculator.sum(input);
        }).isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("this input is not valid, value : %s", expected);
    }
}
