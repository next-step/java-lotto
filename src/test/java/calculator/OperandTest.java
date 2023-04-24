package calculator;

import calculator.domain.Operand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperandTest {
    @DisplayName("피연산자 숫자 동등 비교가 가능하다")
    @Test
    void equals() {
        assertThat(new Operand(1)).isEqualTo(new Operand(1));
    }

    @DisplayName("정수 입력 시 피연산자 객체 생성")
    @Test
    void create() {
        assertThat(Operand.from("0")).isEqualTo(new Operand(0));
        assertThat(Operand.from("10")).isEqualTo(new Operand(10));
    }

    @DisplayName("문자 입력 시 예외 발생")
    @Test
    void createFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Operand.from("A"))
                .withMessageContaining("Invalid operand");
    }

    @DisplayName("null 또는 빈 문자열 입력 시 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Operand.from(input))
                .withMessageContaining("Invalid operand");
    }
}
