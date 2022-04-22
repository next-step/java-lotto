package string_calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticTest {
    @Test
    void add() {
        assertThat(Arithmetic.add(new Integer(1),new Integer(2))).isEqualTo(new Integer(3));
    }

    @Test
    void handleOperator() {
        List<Value> values = new ArrayList<Value>() {{
            add(new Integer(1));
            add(new Operator("+"));
            add(new Integer(2));
        }};
        Arithmetic a = new Arithmetic();
        assertThat(a.computes(values)).isEqualTo(new Integer(3));
    }
}
