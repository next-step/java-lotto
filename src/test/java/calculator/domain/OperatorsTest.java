package calculator.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorsTest {

    @Test
    void of() {
        Operators expected = new Operators(List.of(Operator.ADD, Operator.SUBTRACT, Operator.MULTIPLY, Operator.DIVIDE));

        Operators actual = Operators.of(List.of("+", "-", "*", "/"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void min_size() {
        ThrowingCallable actual = () -> new Operators(new ArrayList<>());

        assertThatThrownBy(actual)
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("적어도 1개의 연산자가 입력되어야 합니다.");
    }

    @Test
    void size() {
        int actual = new Operators(List.of(Operator.ADD, Operator.SUBTRACT, Operator.MULTIPLY, Operator.DIVIDE)).size();

        assertThat(actual).isEqualTo(4);
    }
}
