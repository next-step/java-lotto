package com.kkambi.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @DisplayName("문자열로 된 계산식을 원소들로 나눈다")
    @MethodSource("getFormulaString")
    @ParameterizedTest
    void split(String formulaString, List<String> expected) {
        // when
        // then
        List<String> elements = StringAddCalculator.split(formulaString);
        assertThat(elements).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> getFormulaString() {
        return Stream.of(
                Arguments.of(null, Collections.singletonList("0")),
                Arguments.of("", Collections.singletonList("0")),
                Arguments.of("10", Collections.singletonList("10")),
                Arguments.of("1,2", Arrays.asList("1", "2")),
                Arguments.of("1,2:3", Arrays.asList("1", "2", "3")),
                Arguments.of("//;\n1;2;3", Arrays.asList("1", "2", "3"))
        );
    }

    @DisplayName("문자열로 된 계산식의 합을 반환한다")
    @ValueSource(strings = {"6", "2,4", "1,2:3", "//;\n1;2;3"})
    @ParameterizedTest
    void sum(String formulaString) {
        // given
        List<String> elements = StringAddCalculator.split(formulaString);

        // when
        // then
        assertThat(StringAddCalculator.sum(elements)).isEqualTo(6);
    }


    @DisplayName("숫자가 아닌 값이나, 음수를 넣으면 예외를 반환한다")
    @ValueSource(strings = {"-1,2,3", "+,2,3"})
    @ParameterizedTest
    void sumThrowingException(String formulaString) {
        // given
        List<String> elements = StringAddCalculator.split(formulaString);

        // when
        // then
        assertThatThrownBy(() -> StringAddCalculator.sum(elements))
                .isInstanceOf(RuntimeException.class);
    }
}
