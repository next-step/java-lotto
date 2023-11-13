package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.controller.StringCalculatorMain;
import stringcalculator.model.Calculator;
import stringcalculator.model.Operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @Test
    void 덧셈() {
        Operator operator = new Operator();
        int actual = operator.add(1, 3);
        assertThat(actual).isEqualTo(4);
    }

    @Test
    void 뺄셈() {
        Operator operator = new Operator();
        int actual = operator.minus(5, 3);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        Operator operator = new Operator();
        int actual = operator.multiply(3, 5);
        assertThat(actual).isEqualTo(15);
    }

    @Test
    void 나눗셈() {
        Operator operator = new Operator();
        int actual = operator.division(10, 5);
        assertThat(actual).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"^", "%"})
    void 다른_사칙연산_예외(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           new Operator(input);
        });
    }
}
