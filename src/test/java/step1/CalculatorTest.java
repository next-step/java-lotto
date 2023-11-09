package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.domain.Calculator;
import step1.domain.Operator;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈을 할 수 있다")
    public void plus() {
        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(2, 3));
        LinkedList<Operator> operators = new LinkedList<>(Arrays.asList(Operator.PLUS));
        assertThat(Calculator.calculation(numbers, operators)).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈을 할 수 있다")
    public void minus() {
        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(2, 3));
        LinkedList<Operator> operators = new LinkedList<>(Arrays.asList(Operator.MINUS));
        assertThat(Calculator.calculation(numbers, operators)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈을 할 수 있다")
    public void multiply() {
        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(2, 3));
        LinkedList<Operator> operators = new LinkedList<>(Arrays.asList(Operator.MULTIPLY));
        assertThat(Calculator.calculation(numbers, operators)).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈을 할 수 있다")
    public void divide() {
        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(2, 3));
        LinkedList<Operator> operators = new LinkedList<>(Arrays.asList(Operator.DIVIDE));
        assertThat(Calculator.calculation(numbers, operators)).isEqualTo(0);
    }

}
