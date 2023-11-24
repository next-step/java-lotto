package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.model.Operator;
import stringcalculator.model.Operators;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @Test
    void 덧셈() {
        int actual = Operator.PLUS.apply(1, 3);
        assertThat(actual).isEqualTo(4);
    }

    @Test
    void 뺄셈() {
        int actual = Operator.MINUS.apply(5, 3);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        int actual = Operator.MULTIPLY.apply(3, 5);
        assertThat(actual).isEqualTo(15);
    }

    @Test
    void 나눗셈() {
        int actual = Operator.DIVISION.apply(10, 5);
        assertThat(actual).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"^", "%"})
    void 다른_사칙연산_예외(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           new Operators(input);
        });
    }
}
