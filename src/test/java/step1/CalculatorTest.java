package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    public void 덧셈_값_계산() {
        Assertions.assertThat(Calculator.calculator("2 + 3")).isEqualTo(5);
    }

    @Test
    public void 뺄셈_값_계산() {
        Assertions.assertThat(Calculator.calculator("2 - 3")).isEqualTo(-1);
    }

    @Test
    public void 곱셈_값_계산() {
        Assertions.assertThat(Calculator.calculator("2 * 3")).isEqualTo(6);
    }

    @Test
    public void 나눗셈_값_계산() {
        Assertions.assertThat(Calculator.calculator("6 / 2")).isEqualTo(3);
    }

    @Test
    public void 여러_값을_입력_했을_때() {
        Assertions.assertThat(Calculator.calculator("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    public void null_입력했을_때() {
        assertThatThrownBy(() -> Calculator.calculator(null)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력값은 null이거나 공백일 수 없습니다.");
    }

    @Test
    public void 공백을_입력했을_때() {
        assertThatThrownBy(() -> Calculator.calculator("")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력값은 null이거나 공백일 수 없습니다.");
    }

    @Test
    public void 숫자위치에_숫자가_아닐_때() {
        assertThatThrownBy(() -> Calculator.calculator(", * 2")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 숫자입니다.");
    }

    @Test
    public void 연산자위치에_연산자가_아닐_때() {
        assertThatThrownBy(() -> Calculator.calculator("1 , 2")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("잘못된 사칙연산 기호 입니다.");
    }
}
