package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.calculator.domain.Operand;

import static org.assertj.core.api.Assertions.*;

public class OperandTest {
    @DisplayName("양의 정수와 0을 입력받을 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void positiveNumberOrZero(int number) {
        Operand operand = new Operand(number);
        assertThat(operand.equals(new Operand(number))).isTrue();
    }

    @DisplayName("null 을 입력하면 0으로 인식한다.")
    @Test
    void notAllowNegative() {
        Operand operand = new Operand(null);
        assertThat(operand.getOperand()).isEqualTo(0);
    }

    @DisplayName("음수를 입력하면 에러가 난다.")
    @Test
    void negativeNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Operand(-1);
                });
    }
}
