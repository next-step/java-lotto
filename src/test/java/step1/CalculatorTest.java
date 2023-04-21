package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void plus() {
        Operation operation = new Operation("1", "3", "+");
        assertThat(Calculator.calculate(operation))
                .isEqualTo("4");
    }

    @Test
    void minus() {
        Operation operation = new Operation("3", "1", "-");
        assertThat(Calculator.calculate(operation))
                .isEqualTo("2");
    }

    @Test
    void multiply() {
        Operation operation = new Operation("2", "4", "*");
        assertThat(Calculator.calculate(operation))
                .isEqualTo("8");
    }

    @Test
    void divide() {
        Operation operation = new Operation("8", "4", "/");
        assertThat(Calculator.calculate(operation))
                .isEqualTo("2");
    }
}
