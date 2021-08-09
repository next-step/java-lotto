package com.lotto.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
