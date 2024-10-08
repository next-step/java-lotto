package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperaterTest {
    @Test
    @DisplayName("덧셈 테스트")
    void 덧셈_테스트() {
        StringCalculator cal = new StringCalculator("2+5");

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(7);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void 뺄셈_테스트() {
        StringCalculator cal = new StringCalculator("5-2");

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(3);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void 곱셈_테스트() {
        StringCalculator cal = new StringCalculator("5*2");

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(10);
    }


    @Test
    @DisplayName("나눗셈 테스트")
    void 나눗셈_테스트() {
        StringCalculator cal = new StringCalculator("5/2");

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(2);
    }


    @Test
    @DisplayName("복잡한 연산 테스트")
    void 복잡한_연산_테스트() {
        StringCalculator cal = new StringCalculator("2 + 3 * 4 / 2");

        Assertions.assertThat(cal.calculateExpression()).isEqualTo(10);
    }

    @Test
    @DisplayName("잘못된 연산기호인지 확인한다")
    void 잘못된_연산기호_테스트() {

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        OperaterSelection.selection("^"))
                .withMessage("잘못된 기호");

    }


}
