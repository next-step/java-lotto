package com.lotto.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumberSplitterTest {
    @DisplayName("기본 구분자 테스트")
    @ParameterizedTest
    @CsvSource({"'1,2,3,4', 4", "'1:2:3', 3", "'1:2,3', 3"})
    public void defaultSeparatorSplit(String input, int expected) {
        //when
        int[] numbers = NumberSplitter.split(input);

        //then
        assertThat(numbers.length).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자 테스트")
    @ParameterizedTest
    @CsvSource({"'//;\n1;2;3;4', 4", "'//;\n1;2:3', 3", "'//;\n0;1:2,3', 4"})
    public void customSeparatorSplit(String input, int expected) {
        //when
        int[] numbers = NumberSplitter.split(input);

        //then
        assertThat(numbers.length).isEqualTo(expected);
    }

    @DisplayName("올바르지 않는 값 있을 시 테스트")
    @ParameterizedTest
    @CsvSource({"'1:-1:2', -1", "'1:a:2', a", "'//;\n1;-2;3;4', -2", "'//;\n1;a;3;4', a"})
    public void invalidInput(String input, String expected) {
        //then
        assertThatThrownBy(() -> {
            NumberSplitter.split(input);
        }).isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("this input is not valid, value : %s", expected);
    }

    @DisplayName("null 값 넘길 시 테스트")
    @Test
    public void nullInput() {
        //given
        String input = null;

        //when
        int[] result = NumberSplitter.split(input);

        //then
        assertThat(result.length).isEqualTo(0);
    }

    @DisplayName("빈값 넘길 시 테스트")
    @Test
    public void emptyInput() {
        //given
        String input = "";

        //when
        int[] result = NumberSplitter.split(input);

        //then
        assertThat(result.length).isEqualTo(0);
    }
}
