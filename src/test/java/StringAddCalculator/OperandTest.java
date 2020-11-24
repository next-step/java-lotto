package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperandTest {

    @DisplayName(value = "음수를 전달할 경우 RuntimeException")
    @Test
    void 음수일_경우_예외() {
        assertThatThrownBy(() -> new Operand(0).plus("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName(value = "숫자가 아닐경우 경우 NumberFormatException")
    @Test
    void 숫자가_아닐_경우_예외() {
        assertThatThrownBy(() -> new Operand(0).plus("d"))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName(value = "기존 값과 더하여 새로운 객체를 반환한다.")
    @Test
    void 덧셈_테스트() {
        // given
        Operand operand1 = new Operand(1);

        // when
        Operand operand2 = operand1.plus("3");

        // then
        assertThat(operand2).isEqualTo(new Operand(4));
    }
}