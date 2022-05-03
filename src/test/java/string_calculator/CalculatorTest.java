package string_calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    void handlePlusOperator() {
        List<Object> values = new ArrayList<>() {{
            add(new Integer(1));
            add(Operator.PLUS);
            add(new Integer(2));
        }};
        Calculator calculator = new Calculator();
        assertThat(calculator.computes(values)).isEqualTo(new Integer(3));
    }

    @Test
    void handleOperators() {
        List<Object> values = new ArrayList<>() {{
            add(new Integer(1));
            add(Operator.PLUS);
            add(new Integer(2));
            add(Operator.MULTIPLY);
            add(new Integer(4));
            add(Operator.DIVIDE);
            add(new Integer(2));
            add(Operator.MODULO);
            add(new Integer(5));
        }};
        Calculator calculator = new Calculator();
        assertThat(calculator.computes(values)).isEqualTo(new Integer(1));
    }

    @Test
    void shouldThrowErrorIfResultIsNotInteger() {
        Parser parser = new Parser();
        parser.parse("3 / 2");
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.computes(parser.values)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowErrorIfDividedByZero() {
        Parser parser = new Parser();
        parser.parse("3 / 0");
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.computes(parser.values)).isInstanceOf(ArithmeticException.class);
    }

    @Test
    void shouldReturnCorrectAnswer() {
        Parser parser = new Parser();
        parser.parse("2 + 3 * 4 / 2");
        Calculator calculator = new Calculator();
        assertThat(calculator.computes(parser.values)).isEqualTo(new Integer(10));
    }
}
