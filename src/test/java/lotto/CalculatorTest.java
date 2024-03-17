package lotto;

import lotto.domain.Calculator;
import lotto.domain.Expression;
import lotto.domain.ExpressionElementBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @Test
    @DisplayName("[성공] 두 숫자를 더한다.")
    void 덧셈() {
        Expression expression = new Expression(ExpressionElementBuilder.build(new ArrayList<>(List.of("2", "+", "3"))));
        assertThat(Calculator.calculate(expression)).isEqualTo(5);
    }

    @Test
    @DisplayName("[성공] 두 숫자를 뺀다.")
    void 뺄셈() {
        Expression expression = new Expression(ExpressionElementBuilder.build(new ArrayList<>(List.of("3", "-", "2" ))));
        assertThat(Calculator.calculate(expression)).isEqualTo(1);
    }

    @Test
    @DisplayName("[성공] 두 숫자를 곱한다.")
    void 곱셈() {
        Expression expression = new Expression(ExpressionElementBuilder.build(new ArrayList<>(List.of( "3", "*", "2" ))));
        assertThat(Calculator.calculate(expression)).isEqualTo(6);
    }

    @Test
    @DisplayName("[성공] 두 숫자를 나눈다.")
    void 나눗셈() {
        Expression expression = new Expression(ExpressionElementBuilder.build(new ArrayList<>(List.of( "4", "/", "2" ))));
        assertThat(Calculator.calculate(expression)).isEqualTo(2);
    }

    @Test
    @DisplayName("[성공] 두 숫자를 나눈 결과가 정수가 아닌 경우 소수점을 버린다.")
    void 나눗셈_반올림() {
        Expression expression = new Expression(ExpressionElementBuilder.build(List.of("3", "/", "2" )));
        assertThat(Calculator.calculate(expression)).isEqualTo(1);
    }

    @Test
    @DisplayName("[실패] 나누기 연산에 0을 사용해 나누는 경우 ArithmeticException 예외가 발생한다.")
    void 나눗셈_0으로_나누기() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    Expression expression = new Expression(ExpressionElementBuilder.build(List.of("3", "/", "0" )));
                    Calculator.calculate(expression);
                });
    }
}
