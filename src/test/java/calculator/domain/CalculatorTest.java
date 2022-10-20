package calculator.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    @DisplayName("Numbers와 Operators로 생성할 수 있다.")
    @Test
    void create_calculator() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        Operators operators = new Operators(List.of(Operator.ADD, Operator.SUBTRACT));
        Calculator expected = new Calculator(numbers, operators);

        Calculator actual = new Calculator(List.of("1", "+", "2", "-", "3"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("숫자가 연산자 보다 하나가 더 많지 않으면 예외가 발생한다.")
    @Test
    void create_validate_computable_size() {
        Numbers numbers = new Numbers(List.of(1, 2));
        Operators operators = new Operators(List.of(Operator.ADD, Operator.SUBTRACT));

        ThrowingCallable actual = () -> new Calculator(numbers, operators);

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("계산이 불가능한 식 입니다. 숫자가 연산자보다 하나 더 많아야합니다.");
    }

    @DisplayName("식을 계산한다.")
    @Test
    void doCalculations() {
        Calculator calculator = new Calculator(List.of("6", "+", "5", "-", "4", "*", "3", "/", "2"));

        int actual = calculator.doCalculations();

        assertThat(actual).isEqualTo(10);
    }
}
