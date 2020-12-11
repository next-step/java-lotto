package com.jaenyeong.mission01.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("주어진 문자열을 구분자를 사용해 숫자 리스트로 파싱하는 Parser 클래스 테스트")
class ParserTest {

    @ParameterizedTest
    @MethodSource("invalidString")
    @DisplayName("빈 문자열을 제공할 시 true 반환 테스트")
    void checkReturnListSizeWhenGivenInputStrIsBlank(final String exp) {
        final Parser parser = new Parser();

        assertTrue(parser.isBlank(exp));
    }

    @Test
    @DisplayName("Null 제공할 시 true 반환 테스트")
    void checkReturnListSizeWhenGivenNull() {
        final Parser parser = new Parser();

        assertTrue(parser.isBlank(null));
    }

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
}
