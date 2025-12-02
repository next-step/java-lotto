package controller;

import domain.Operator;
import domain.OperatorFactory;
import org.junit.jupiter.api.Test;
import java.util.List;

import domain.Number;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void 생성() {
        List<Number> numbers = List.of(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5)

        );
        List<Operator> operators = List.of(
                OperatorFactory.getOperator("+"),
                OperatorFactory.getOperator("-"),
                OperatorFactory.getOperator("*"),
                OperatorFactory.getOperator("/")
        );

        assertThat(new Calculator("1 + 2 - 3 * 4 / 5")).isEqualTo(new Calculator(numbers, operators));
    }

    @Test
    public void 계산() {
        assertThat(new Calculator("1 + 2 - 3 + 5 * 4 / 5").calculate()).isEqualTo(new Number(4));
    }
}
