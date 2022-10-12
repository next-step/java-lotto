package stringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private OperatorMap operatorMap;
    private Values values;

    @BeforeEach
    void init () {
        operatorMap = new OperatorMap();
        values = new Values();

    }

    @Test
    void 덧셈 () {
        values.addValues("+");
        assertThat(operatorMap.calculate(2, 3, values)).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        values.addValues("-");
        assertThat(operatorMap.calculate(5, 3, values)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        values.addValues("*");
        assertThat(operatorMap.calculate(2, 3, values)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        values.addValues("/");
        assertThat(operatorMap.calculate(6, 3, values)).isEqualTo(2);
    }

    @Test
    void 복합() {
        values.addValues("2");
        values.addValues("+");
        values.addValues("3");
        values.addValues("*");
        values.addValues("2");

        assertThat(operatorMap.calculate(values.pollOperand(), values.pollOperand(), values)).isEqualTo(10);
    }
}
