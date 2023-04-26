package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.domain.StringCalculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    @DisplayName("덧셈")
    void 덧셈() {
        StringCalculator sc = new StringCalculator();

        Assertions.assertThat(sc.add(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    void 뻴셈() {
        StringCalculator sc = new StringCalculator();

        Assertions.assertThat(sc.subtract(2, 1)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱셈")
    void 곱셈() {
        StringCalculator sc = new StringCalculator();

        Assertions.assertThat(sc.multiply(2, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈")
    void 나눗셈() {
        StringCalculator sc = new StringCalculator();

        Assertions.assertThat(sc.divide(6, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("사칙연산")
    void 사칙연산() {
        StringCalculator sc = new StringCalculator();

       // Assertions.assertThat(sc.calculate("1 + 2 * 3 / 3")).isEqualTo(3);
    }

    @Test
    @DisplayName("계산식형식체크")
    void 계산식형식체크() {
        assertThatThrownBy(()-> {
            StringCalculator sc = new StringCalculator("2 + 3 * 4 / 5");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("계산식의 형식이 맞지 않습니다.");
    }
}
