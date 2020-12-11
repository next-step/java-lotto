package com.jaenyeong.mission01.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("주어진 문자열을 구분자를 사용해 숫자 리스트로 파싱하는 Parser 클래스 테스트")
class ParserTest {

    @ParameterizedTest
    @MethodSource("invalidString")
    @DisplayName("빈 문자열을 제공할 시 0을 반환하는지 확인하는 테스트")
    void checkReturnValueIsZeroWhenGivenInputStrIsBlank(final String exp) {
        final Parser parser = new Parser();

        final List<Integer> numbers = parser.parseToNumbers(exp);

        final int onlyOne = 1;
        assertEquals(numbers.size(), onlyOne);

        final int expectedValue = 0;
        assertEquals(numbers.get(0), expectedValue);
    }

    @Test
    @DisplayName("Null 제공할 시 0을 반환하는지 확인하는 테스트")
    void checkReturnValueIsZeroWhenGivenNull() {
        final Parser parser = new Parser();

        final List<Integer> numbers = parser.parseToNumbers(null);

        final int onlyOne = 1;
        assertEquals(numbers.size(), onlyOne);

        final int expectedValue = 0;
        assertEquals(numbers.get(0), expectedValue);
    }

    private static Stream<Arguments> invalidString() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of("   "),
            Arguments.of("           ")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "8", "9"})
    @DisplayName("입력 문자열이 1자리 자연수일 때 반환 리스트를 확인하는 테스트")
    void checkReturnListWhenGivenNaturalNumber(final String exp) {
        final Parser parser = new Parser();

        final List<Integer> numbers = parser.splitWhenNumberIsNaturalNumber(exp);
        final int expectedValue = Integer.parseInt(exp);

        assertEquals(numbers.get(0), expectedValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "10", "a", ""})
    @DisplayName("입력 문자열이 1자리 자연수가 아닐 때 반환 리스트를 확인하는 테스트")
    void checkReturnListWhenGivenWhatIsInvalidNaturalNumber(final String exp) {
        assertThatThrownBy(() -> {
            final Parser parser = new Parser();

            final List<Integer> numbers = parser.splitWhenNumberIsNaturalNumber(exp);
            final int expectedValue = Integer.parseInt(exp);

            assertEquals(numbers.get(0), expectedValue);
        })
            .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2", "8,7", "1,2:3", "3:2,1", "4,5,6", "7:8:9"})
    @DisplayName("콤마, 콜론을 기준으로 잘라 반환 리스트를 확인하는 테스트")
    void checkReturnListWhenSplitCommaAndColon(final String exp) {
        final Parser parser = new Parser();
        final String[] splitStrings = exp.split(",|:");

        final List<Integer> numbers = parser.splitWhenNumberIsNaturalNumberList(exp);

        assertEquals(splitStrings.length, numbers.size());

        for (int i = 0; i < numbers.size(); i++) {
            int expectedNumber = Integer.parseInt(splitStrings[i]);
            assertEquals(numbers.get(i), expectedNumber);
        }
    }
}
