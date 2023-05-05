package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    @DisplayName("사칙연산 테스트 : 덧셈")
    @Test
    void 덧셈() {
        Number firstNumber = new Number(10);
        Number secondNumber = new Number(20);
        List<Number> numbers = Arrays.asList(firstNumber, secondNumber);
        List<Operator> operators = Arrays.asList(Operator.PLUS);

        Expression expression = new Expression(numbers, operators);
        Number result = expression.calculate();
        assertThat(result.getNumber()).isEqualTo(30);
    }

    @DisplayName("사칙연산 테스트 : 뺄셈")
    @Test
    void 뺄셈() {
        Number firstNumber = new Number(10);
        Number secondNumber = new Number(20);
        List<Number> numbers = Arrays.asList(firstNumber, secondNumber);
        List<Operator> operators = Arrays.asList(Operator.MINUS);

        Expression expression = new Expression(numbers, operators);
        Number result = expression.calculate();
        assertThat(result.getNumber()).isEqualTo(-10);
    }

    @DisplayName("사칙연산 테스트 : 곱셈")
    @Test
    void 곱셈() {
        Number firstNumber = new Number(10);
        Number secondNumber = new Number(20);
        List<Number> numbers = Arrays.asList(firstNumber, secondNumber);
        List<Operator> operators = Arrays.asList(Operator.MULTIPLY);

        Expression expression = new Expression(numbers, operators);
        Number result = expression.calculate();
        assertThat(result.getNumber()).isEqualTo(200);
    }

    @DisplayName("사칙연산 테스트 : 나눗셈(내림처리)")
    @Test
    void 나눗셈() {
        Number firstNumber = new Number(10);
        Number secondNumber = new Number(20);
        List<Number> numbers = Arrays.asList(firstNumber, secondNumber);
        List<Operator> operators = Arrays.asList(Operator.DIVIDE);

        Expression expression = new Expression(numbers, operators);
        Number result = expression.calculate();
        assertThat(result.getNumber()).isEqualTo(0);
    }

    @DisplayName("2 + 3 * 4 / 2 연산테스트")
    @Test
    void 예시연산_테스트() {
        List<Number> numbers = Arrays.asList(new Number(2),new Number(3), new Number(4), new Number(2));
        List<Operator> operators = Arrays.asList(Operator.PLUS, Operator.MULTIPLY, Operator.DIVIDE);

        Expression expression = new Expression(numbers, operators);
        assertThat(expression.calculate().getNumber()).isEqualTo(10);

    }


}
