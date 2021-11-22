package stringaddcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OperandTest {
    @Test
    @DisplayName("팩토리 메소드를 테스트한다.")
    public void from() {
        assertThat(Operand.from("10")).isEqualTo(new Operand(10));
    }

    @Test
    @DisplayName("음수는 생성할 수 없다.")
    public void negative() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() ->Operand.from("-10"));
    }

    @Test
    @DisplayName("값이 0인 Operand를 생성한다.")
    public void zero() {
        assertThat(Operand.zero()).isEqualTo(Operand.from("0"));
    }

    @Test
    @DisplayName("Operand 끼리의 덧셈")
    public void test() {
        assertThat(Operand.from("1").plus(Operand.from("2"))).isEqualTo(Operand.from("3"));
    }
}
