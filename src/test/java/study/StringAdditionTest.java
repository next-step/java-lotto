package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import study.calculator.domain.StringAddition;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAdditionTest {
    @DisplayName("기본 구분자를 이용한 덧셈")
    @ParameterizedTest
    @CsvSource(value = {"0,1=1", "1:1=2", "1,2:3=6"}, delimiter = '=')
    void defaultSeparator(String operands, int result) {
        assertThat(StringAddition.splitAndSum(operands)).isEqualTo(result);
    }

    @DisplayName("커스텀 구분자를 이용한 덧셈")
    @ParameterizedTest
    @MethodSource("provideStringOperands")
    void customSeparator(String operands, int result) {
        assertThat(StringAddition.splitAndSum(operands)).isEqualTo(result);
    }

    @DisplayName("공백 입력")
    @Test
    void empty() {
        assertThat(StringAddition.splitAndSum("")).isEqualTo(0);
    }

    @DisplayName("null 입력")
    @Test
    void nullValue() {
        assertThat(StringAddition.splitAndSum(null)).isEqualTo(0);
    }

    private static Stream<Arguments> provideStringOperands() {
        return Stream.of(
                Arguments.of("//?\n0?1", 1),
                Arguments.of("//!!\n1!!1", 2),
                Arguments.of("//?\n1,2?3", 6)
        );
    }

}
