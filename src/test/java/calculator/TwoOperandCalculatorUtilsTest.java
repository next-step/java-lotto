package calculator;

import calculator.exception.DivisionCannotBeZeroException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TwoOperandCalculatorUtilsTest {
    @Test
    @DisplayName("덧셈 테스트")
    void 덧셈_테스트() {

        StringExpression expression = new StringExpression("2 + 5");
        StringCalculator calculator = new StringCalculator();

        Assertions.assertThat(calculator.calculateExpression(expression)).isEqualTo(7);

    }

    @Test
    @DisplayName("뺄셈 테스트")
    void 뺄셈_테스트() {

        StringExpression expression = new StringExpression("5 - 2");
        StringCalculator calculator = new StringCalculator();

        Assertions.assertThat(calculator.calculateExpression(expression)).isEqualTo(3);

    }

    @Test
    @DisplayName("곱셈 테스트")
    void 곱셈_테스트() {

        StringExpression expression = new StringExpression("5 * 2");
        StringCalculator calculator = new StringCalculator();

        Assertions.assertThat(calculator.calculateExpression(expression)).isEqualTo(10);

    }


    @Test
    @DisplayName("나눗셈 테스트")
    void 나눗셈_테스트() {

        StringExpression expression = new StringExpression("5 / 2");
        StringCalculator calculator = new StringCalculator();

        Assertions.assertThat(calculator.calculateExpression(expression)).isEqualTo(2);

    }


    @Test
    @DisplayName("복잡한 연산 테스트")
    void 복잡한_연산_테스트() {

        StringExpression expression = new StringExpression("2 + 3 * 4 / 2");
        StringCalculator calculator = new StringCalculator();

        Assertions.assertThat(calculator.calculateExpression(expression)).isEqualTo(10);

    }

    @Test
    @DisplayName("잘못된 연산기호인지 확인한다")
    void 잘못된_연산기호_테스트() {

        TwoOperandCalculator twoOperandCalculator = TwoOperandCalculator.getOperatorSelection();

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->
                        twoOperandCalculator.findOperator("^"))
                .withMessage("^는 잘못된 연산기호 입니다");

    }

    @Test
    @DisplayName("0으로 나눌 시 예외 발생")
    void exceptionOccuredWhenDivideByZero() {

        StringExpression expression = new StringExpression("0 / 0");
        StringCalculator calculator = new StringCalculator();

        Assertions.assertThatExceptionOfType(DivisionCannotBeZeroException.class)
                .isThrownBy(() ->
                        calculator.calculateExpression(expression))
                .withMessage("0 으로 나눌 수 없습니다");

    }

}
