package step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Test;

public class CalculateTest {

    @Test
    public void 사칙연산_혼합_테스트() {
        //userInput = "4 + 2 / 3"
        //expected 2
        Queue<Integer> numbers = makeNumbers();
        Queue<Operator> operators = makeOperators();

        Calculator calculator = new Calculator(numbers, operators);

        assertThat(calculator.calculate()).isEqualTo((4+2)/3);
    }

    private Queue<Integer> makeNumbers() {
        Queue<Integer> numbers = new LinkedList<>();
        numbers.add(4);
        numbers.add(2);
        numbers.add(3);
        return numbers;
    }

    private Queue<Operator> makeOperators() {
        Queue<Operator> operators = new LinkedList<>();
        operators.add(Operator.PLUS);
        operators.add(Operator.DIVISION);
        return operators;
    }
}
