package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("[StringCalculator.cal] 피연산자 2개의 덧셈 계산식 -> 합계 반환")
    public void simpleSumTest() {
        assertThat(StringCalculator.cal("3 + 6"))
                .isEqualTo(9);
    }

    @Test
    @DisplayName("[StringCalculator.cal] 피연산자 2개의 뺄셈 계산식 -> 뺄셈 결과 반환")
    public void simpleSubTest() {
        assertThat(StringCalculator.cal("3 - 6"))
                .isEqualTo(-3);
    }

    @Test
    @DisplayName("[StringCalculator.cal] 피연산자 2개의 곱셈 계산식 -> 곱셈 결과 반환")
    public void simpleMultiTest() {
        assertThat(StringCalculator.cal("3 * 6"))
                .isEqualTo(18);
    }

    @Test
    @DisplayName("[StringCalculator.cal] 피연산자 2개의 나눗셈 계산식 -> 나눗셈 결과 반환")
    public void simpleDivTest() {
        assertThat(StringCalculator.cal("12 / 6"))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("[StringCalculator.cal] 피연산자 3개의 복합 계산식 -> 합계 반환")
    public void threeOperandTest() {
        assertThat(StringCalculator.cal("1 + 4 * 3"))
                .isEqualTo(15);
    }
}
