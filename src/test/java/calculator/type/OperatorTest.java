package calculator.type;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @Test
    void add() {
        int result = new Add().operate(10, 20);

        assertThat(result).isEqualTo(30);
    }

    @Test
    void subtract() {
        int result = new Subtract().operate(20, 10);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void multiply() {
        int result = new Multiply().operate(10, 20);

        assertThat(result).isEqualTo(200);
    }

    @Test
    void divide() {
        int result = new Divide().operate(20, 5);

        assertThat(result).isEqualTo(4);
    }
}
