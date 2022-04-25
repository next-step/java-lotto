package string_calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArithmeticTest {
//    @Test
//    void add() {
//        assertThat(Arithmetic.add(new Integer(1), new Integer(2))).isEqualTo(new Integer(3));
//    }

    @Test
    void handlePlusOperator() {
        List<Value> values = new ArrayList<Value>() {{
            add(new Integer(1));
            add(Operator.PLUS);
            add(new Integer(2));
        }};
        Arithmetic a = new Arithmetic();
        assertThat(a.computes(values)).isEqualTo(new Integer(3));
    }

    @Test
    void handleOperators() {
        List<Value> values = new ArrayList<Value>() {{
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
        Arithmetic a = new Arithmetic();
        assertThat(a.computes(values)).isEqualTo(new Integer(1));
    }

    @Test
    void shouldThrowErrorIfResultIsNotInteger() {
        Parser p = new Parser();
        p.parse("3 / 2");
        Arithmetic a = new Arithmetic();
        assertThatThrownBy(() -> a.computes(p.values)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldThrowErrorIfDividedByZero() {
        Parser p = new Parser();
        p.parse("3 / 0");
        Arithmetic a = new Arithmetic();
        assertThatThrownBy(() -> a.computes(p.values)).isInstanceOf(ArithmeticException.class);
    }

    @Test
    void shouldReturnCollectAnswer() {
        Parser p = new Parser();
        p.parse("2 + 3 * 4 / 2");
        Arithmetic a = new Arithmetic();
        assertThat(a.computes(p.values)).isEqualTo(new Integer(10));
    }
}
