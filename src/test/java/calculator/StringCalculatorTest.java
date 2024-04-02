package calculator;

import calculator.fixtures.StringCalculatorFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void null_값(String expression) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator().calculate(expression))
                .withMessageMatching("입력 값이 비어있습니다.");
    }

    @Test
    void split() {
        String[] expression = "2 + 3 * 4 / 2".split(" ");
        assertThat(expression).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    void 사칙연산_기호_아닌_경우() {
        String expression = "2 + 3 > 5";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator().calculate(expression))
                .withMessageMatching("사칙연산 기호가 아닙니다.");
    }

    @Test
    void 잘못된_요소_개수() {
        String expression = "2 + 3 -";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator().calculate(expression))
                .withMessageMatching("입력한 식이 잘못되었습니다.");
    }

    @Test
    void 잘못된_식_나열() {
        String expression = "+ 2 3 - 5";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new StringCalculator().calculate(expression))
                .withMessageMatching("잘못된 숫자/연산자 나열입니다.");
    }

    @Test
    void 정수_변환() {
        String expression = "5";
        assertThat(Integer.parseInt(expression)).isEqualTo(5);
    }

    @Test
    void push() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        assertThat(stack.peek()).isEqualTo(1);
    }

    @Test
    void peek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1); stack.push(2);
        assertThat(stack.peek()).isEqualTo(2);
    }

    @Test
    void pop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    void isEmpty() {
        assertThat(new Stack<>().isEmpty()).isTrue();
    }

    @Test
    void add() {
        String operator = "+";
        assertThat(new StringCalculator().apply(StringCalculatorFixture.NUM1, StringCalculatorFixture.NUM2, operator))
                .isEqualTo(7);
    }

    @Test
    void substract() {
        String operator = "-";
        assertThat(new StringCalculator().apply(StringCalculatorFixture.NUM1, StringCalculatorFixture.NUM2, operator))
                .isEqualTo(3);
    }

    @Test
    void multiply() {
        String operator = "*";
        assertThat(new StringCalculator().apply(StringCalculatorFixture.NUM1, StringCalculatorFixture.NUM2, operator))
                .isEqualTo(10);
    }

    @Test
    void divide() {
        String operator = "/";
        assertThat(new StringCalculator().apply(StringCalculatorFixture.NUM1, StringCalculatorFixture.NUM2, operator))
                .isEqualTo(2);
    }

    @Test
    void dividedByZero() {
        String expression = "2 / 0";
        assertThatThrownBy(() -> new StringCalculator().calculate(expression))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void 사칙_연산() {
        String expression = "2 * 3 + 4 / 2";
        assertThat(new StringCalculator().calculate(expression)).isEqualTo(5);
    }

    @Test
    void 덧셈_기호() {
        String operator = "+";
        assertThat(operator).isEqualTo(StringCalculatorFixture.ADD);
    }

    @Test
    void 뺄셈_기호() {
        String operator = "-";
        assertThat(operator).isEqualTo(StringCalculatorFixture.SUBSTRACT);
    }

    @Test
    void 곱셈_기호() {
        String operator = "*";
        assertThat(operator).isEqualTo(StringCalculatorFixture.MULTIPLY);
    }
}