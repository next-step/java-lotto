package stringCalculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BasicOperationsTest {

    @ParameterizedTest
    @MethodSource("provideOperatorAndFunction")
    @DisplayName("사칙 연산 기호를 찾아 반환합니다.")
    void return_matched_basic_operation(String operator, BasicOperations expected) {
        assertThat(BasicOperations.match(operator)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOperatorAndFunction() {
        return Stream.of(
            Arguments.of("+", BasicOperations.PLUS),
            Arguments.of("-", BasicOperations.SUBTRACT),
            Arguments.of("*", BasicOperations.MULTIPLY),
            Arguments.of("/", BasicOperations.DIVIDE)
        );
    }

    @Test
    @DisplayName("사칙 연산 기호에 따른 연산을 합니다.")
    void calculate_numbers() {
        assertThat(BasicOperations.PLUS.calculate(6, 2)).isEqualTo(8);
        assertThat(BasicOperations.SUBTRACT.calculate(6, 2)).isEqualTo(4);
        assertThat(BasicOperations.MULTIPLY.calculate(6, 2)).isEqualTo(12);
        assertThat(BasicOperations.DIVIDE.calculate(6, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("사칙 연산 기호가 아닐시 IllegalArgumentException을 던진다.")
    void is_not_basic_operations() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> BasicOperations.match("1"));
    }
}
