package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {
    @Test
    @DisplayName("숫자가 아닌 값이 입력되었을 때 예외를 발생시킨다.")
    void nonNumberOperandTest() {
        assertThatThrownBy(() -> {
            Operand operand = new Operand("a");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값이 입력되었습니다. 값 : a");
    }

    @Test
    @DisplayName("음수 값 입력시 예외를 발생시킨다.")
    void negativeOperandTest() {
        assertThatThrownBy(() -> {
            Operand operand = new Operand("-1");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수 값이 입력되었습니다. 값 : -1");
    }

    @Test
    @DisplayName("양수 값이 입력되는지 확인한다.")
    void positiveOperandTest() {
        String value = "1";
        Operand operand = new Operand(value);
        assertThat(operand.isSameValue(Integer.parseInt(value))).isTrue();
    }

    @Test
    @DisplayName("0이 입력되는지 확인한다.")
    void zeroOperandTest() {
        String value = "0";
        Operand operand = new Operand(value);
        assertThat(operand.isSameValue(Integer.parseInt(value))).isTrue();
    }
}
