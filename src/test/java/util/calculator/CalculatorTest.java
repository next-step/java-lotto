package util.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.calculator.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    @DisplayName("[StringCalculator.cal] 사칙 연산 총 동원 복합 계산식 -> 합계 반환")
    public void allOperatorTest() {
        assertThat(StringCalculator.cal("1 - 6 + 20 * 30 / 5"))
                .isEqualTo(90);
    }

    @Test
    @DisplayName("[StringCalculator.cal] null 입력 시 -> IllegalArgumentException")
    public void nullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.cal(null);
        });
    }

    @Test
    @DisplayName("[StringCalculator.cal] 빈 문자열 입력 시 -> IllegalArgumentException")
    public void emptyStringTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.cal("");
        });
    }

    @Test
    @DisplayName("[StringCalculator.cal] 정의되지 않은 연산 기호 입력 시 -> IllegalArgumentException")
    public void unknownOperatorTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.cal("15 % 5");
        });
    }
}
