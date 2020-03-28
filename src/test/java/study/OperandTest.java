package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.calculator.domain.Operand;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class OperandTest {
    @DisplayName("양의 정수와 0을 입력받을 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void positiveNumberOrZero(int number) {
        Operand operand = Operand.getInstance(number);
        assertThat(operand.equals(Operand.getInstance(number))).isTrue();
    }

    @DisplayName("null 을 입력하면 0으로 인식한다.")
    @Test
    void notAllowNegative() {
        Operand operand = Operand.getInstance(null);
        assertThat(operand.getOperand()).isEqualTo(0);
    }

    @DisplayName("음수를 입력하면 에러가 난다.")
    @Test
    void negativeNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Operand.getInstance(-1);
                });
    }

    @DisplayName("문자로된 숫자를 입력할수도 있다.")
    @ParameterizedTest
    @MethodSource("provideOperands")
    void string(String value, int expect) {
        assertThat(Operand.getInstance(value).getOperand()).isEqualTo(expect);
    }

    private static Stream<Arguments> provideOperands() {
        return Stream.of(
                Arguments.of("1", 1),
                Arguments.of(null, 0),
                Arguments.of("", 0)
        );
    }
}
