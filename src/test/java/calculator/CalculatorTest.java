package calculator;

import calculator.model.Calculator;
import calculator.model.Classifier;
import calculator.model.InputNumber;
import calculator.model.Operator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

public class CalculatorTest {
    @Test
    void 입력값_null_공백() {
        assertThatThrownBy(() -> Classifier.classifyInteger(new String[]{})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사칙연산기호() {
        assertThatThrownBy(() -> Operator.isOperator(List.of("3"))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 덧셈() {
        //given
        InputNumber numbers = new InputNumber(List.of(1, 2));
        Operator operators = new Operator(List.of("+"));
        Calculator calculator = new Calculator(numbers, operators);
        //then
        assertThat(calculator.calculate()).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        //given
        InputNumber numbers = new InputNumber(List.of(1, 2));
        Operator operators = new Operator(List.of("-"));
        Calculator calculator = new Calculator(numbers, operators);
        //then
        assertThat(calculator.calculate()).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        //given
        InputNumber numbers = new InputNumber(List.of(1, 2));
        Operator operators = new Operator(List.of("*"));
        Calculator calculator = new Calculator(numbers, operators);
        //then
        assertThat(calculator.calculate()).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        //given
        InputNumber numbers = new InputNumber(List.of(1, 2));
        Operator operators = new Operator(List.of("/"));
        Calculator calculator = new Calculator(numbers, operators);
        //then
        assertThat(calculator.calculate()).isEqualTo(0);
        assertThat(calculator.calculate()).isInstanceOf(Integer.class);
    }

    @Test
    void 우선순위_무시() {
        //given
        InputNumber numbers = new InputNumber(List.of(2, 3, 4, 2));
        Operator operators = new Operator(List.of("+", "*", "/"));
        Calculator calculator = new Calculator(numbers, operators);
        //then
        assertThat(calculator.calculate()).isEqualTo(10);
    }
}
