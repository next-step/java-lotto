package com.jaenyeong.mission01.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("문자열 계산기 StringAddCalculator 클래스 테스트")
class StringAddCalculatorTest {

    @ParameterizedTest
    @MethodSource("numbersList")
    @DisplayName("덧셈 테스트")
    void checkSum(final List<Integer> numbers) {
        final int result = StringAddCalculator.getSum(numbers);

        final int expectedValue = numbers.stream().reduce(0, Integer::sum);
        assertEquals(result, expectedValue);
    }

    private static Stream<Arguments> numbersList() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3)),
            Arguments.of(Arrays.asList(5, 6, 7, 8, 9)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }

    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}
