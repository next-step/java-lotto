package com.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorElementTest {

    @DisplayName("각 요소들의 타입을 String -> Integer 타입으로 변경하는 중 실패하는 테스트")
    @ParameterizedTest
    @MethodSource("provideAbnormalDummyElements")
    void convertAllElementsFailureTest(final List<String> elements) {
        CalculatorElement calculatorElement = new CalculatorElement();
        assertThatThrownBy(() -> calculatorElement.validateElements(elements))
                .isInstanceOf(NumberFormatException.class);
    }

    private static Stream<Arguments> provideAbnormalDummyElements() {
        return Stream.of(
                Arguments.of(Arrays.asList("1", "R", "3")),
                Arguments.of(Arrays.asList("^", "5")),
                Arguments.of(Arrays.asList("4", "+"))
        );
    }

    @DisplayName("각 요소들의 값을 검증하다가 음수가 나와서 실패하는 테스트")
    @ParameterizedTest
    @MethodSource("provideNegativeDummyElements")
    void validateElementsFailureTest(final List<String> elements) {
        CalculatorElement calculatorElement = new CalculatorElement();

        assertThatThrownBy(() -> calculatorElement.validateElements(elements))
                .isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideNegativeDummyElements() {
        return Stream.of(
                Arguments.of(Arrays.asList("1", "-1", "3")),
                Arguments.of(Arrays.asList("3", "-5")),
                Arguments.of(Arrays.asList("-4", "7"))
        );
    }

    @DisplayName(
            "1. 각 요소들의 타입을 String -> Integer 타입으로 변경하는 테스트" +
                    "2. 각 요소들의 값을 검증하는 테스트" +
                    "3. 각 요소들의 합을 구하는 테스트"
    )
    @ParameterizedTest
    @MethodSource("provideNormalDummyElements")
    void convertAndAddAllElementsTest(final List<String> elements, final Integer expected) {
        CalculatorElement calculatorElement = new CalculatorElement();

        calculatorElement.validateElements(elements);
        Integer result = calculatorElement.addAllElements();

        assertEquals(result, expected);
    }

    private static Stream<Arguments> provideNormalDummyElements() {
        return Stream.of(
                Arguments.of(Arrays.asList("1", "2", "3"), 6),
                Arguments.of(Arrays.asList("4", "5"), 9),
                Arguments.of(Arrays.asList("2", "7"), 9)
        );
    }
}
