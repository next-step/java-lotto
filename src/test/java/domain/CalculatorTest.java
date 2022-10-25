package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void calculate() {
        Calculator calculator = Calculator.getInstance();
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 /", "2 2 3 1", "+ / * 3"})
    void calculate_wrong_text(String text) {
        Calculator calculator = Calculator.getInstance();

        assertThatThrownBy(() -> {
            calculator.calculate("2 + 3 * 4 /");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void extractOperand() {
        Deque<String> operandDeque = new LinkedList(Arrays.asList(2L, 3L, 4L, 2L));
        assertThat(OperandExtractor.getInstance().extractToDeque("2 + 3 * 4 / 2")).isEqualTo(operandDeque);
    }

    @Test
    void extractOperator() {
        Deque<String> operatorDeque = new LinkedList(Arrays.asList("+", "*", "/"));
        assertThat(OperatorExtractor.getInstance().extractToDeque("2 + 3 * 4 / 2")).isEqualTo(operatorDeque);
    }

    @Test
    void add() {
        Calculator calculator = Calculator.getInstance();
        assertThat(calculator.add(1, 2)).isEqualTo(3);
    }

    @Test
    void subtract() {
        Calculator calculator = Calculator.getInstance();
        assertThat(calculator.subtract(2, 1)).isEqualTo(1);
    }

    @Test
    void multiple() {
        Calculator calculator = Calculator.getInstance();
        assertThat(calculator.multiple(2, 2)).isEqualTo(4);
    }

    @Test
    void divide() {
        Calculator calculator = Calculator.getInstance();
        assertThat(calculator.divide(6, 2)).isEqualTo(3);
    }

    @Test
    void divide_by_zero() {
        Calculator calculator = Calculator.getInstance();

        assertThatThrownBy(() -> {
            calculator.divide(6, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void as() {
        Map<Rank, Integer> rankIntegerMap = new HashMap<>();
        rankIntegerMap.put(Rank.ONE, 1);
        rankIntegerMap.computeIfPresent(Rank.ONE, (k, v) -> v+1);

        System.out.println(rankIntegerMap.get(Rank.ONE));
    }
}
