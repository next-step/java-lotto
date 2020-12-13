package com.jaenyeong.mission01.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("주어진 문자열을 파싱하기 위한 조건을 검사하는 Validator 유틸 클래스 테스트")
class ValidatorTest {

    @ParameterizedTest
    @MethodSource("invalidString")
    @DisplayName("빈 문자열을 제공할 시 true 반환 테스트")
    void checkReturnListSizeWhenGivenInputStrIsBlank(final String exp) {
        assertTrue(Validator.isBlank(exp));
    }

    @Test
    @DisplayName("Null 제공할 시 true 반환 테스트")
    void checkReturnListSizeWhenGivenNull() {
        assertTrue(Validator.isBlank(null));
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
    @DisplayName("입력 문자열이 1자리 자연수일 때 확인하는 테스트")
    void checkNaturalNumber(final String numbers) {
        assertTrue(Validator.isNaturalNumber(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "10", "a", ""})
    @DisplayName("입력 문자열이 1자리 자연수가 아닐 때 확인하는 테스트")
    void checkNaturalNumberWhenGivenWhatIsInvalidNaturalNumber(final String exp) {
        assertFalse(Validator.isNaturalNumber(exp));
    }
}
