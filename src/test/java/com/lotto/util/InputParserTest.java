package com.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputParserTest {
    @DisplayName("숫자 값 입력 테스트")
    @ParameterizedTest
    @CsvSource({"'3, 4,2,3,5,6', 6", "'1,2,3,4,5,6,7,8,9', 9", "'8, 3, 6, 1, 8', 5"})
    public void parseNumbersTest(String given, int expected) {
        //when
        List<Integer> numbers = InputParser.parseNumbers(given);

        //then
        assertThat(numbers.size()).isEqualTo(expected);
    }

    @DisplayName("잘못된 숫자 값 입력 테스트")
    @Test
    public void parseWrongNumbersTest() {
        //given
        String input = "3, 5, 6, @$";

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputParser.parseNumbers(input);
        });
    }

    @DisplayName("단일 숫자 값 입력 테스트")
    @ParameterizedTest
    @CsvSource({"3,3", "7,7", "12,12"})
    public void convertTest(String input, int expected) {
        //when
        int actual = InputParser.convert(input);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("단일 숫자 잘못된 값 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"ㄱ", "!@", "abc"})
    public void convertWrongTest(String input) {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            InputParser.convert(input);
        });
    }
}
