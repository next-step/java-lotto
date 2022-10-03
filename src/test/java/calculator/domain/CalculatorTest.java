package calculator.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @Test
    void create_calculator() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        Operators operators = new Operators(List.of(Operator.ADD, Operator.SUBTRACT));
        Calculator expected = new Calculator(numbers, operators);

        Calculator actual = new Calculator(List.of("1", "+", "2", "-", "3"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void create_validate_computable_size() {
        Numbers numbers = new Numbers(List.of(1, 2));
        Operators operators = new Operators(List.of(Operator.ADD, Operator.SUBTRACT));

        ThrowingCallable actual = () -> new Calculator(numbers, operators);

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("계산이 불가능한 식 입니다. 숫자가 연산자보다 하나 더 많아야합니다.");
    }

    @Test
    void doCalculations() {
        Calculator calculator = new Calculator(List.of("6", "+", "5", "-", "4", "*", "3", "/", "2"));
        //Calculator calculator = new Calculator(List.of("6", "+", "5"));

        int actual = calculator.doCalculations();

        assertThat(actual).isEqualTo(10);
    }
}
