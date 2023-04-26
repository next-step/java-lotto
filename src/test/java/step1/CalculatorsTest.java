package step1;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 2 + 3 * 4 / 2 = 20
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class CalculatorsTest {

    private int actual = 2;
    private final int expected = 10;

    @Test
    @Order(1)
    void plus() {
        final var calculator = Calculator.PLUS;

        actual = calculator.calculate(2, 3);
    }

    @Test
    @Order(2)
    void multiply() {
        final var calculator = Calculator.MULTIPLY;

        actual = calculator.calculate(5, 4);
    }

    @Test
    @Order(3)
    void divide() {
        final var calculator = Calculator.DIVIDE;

        actual = calculator.calculate(20, 2);

        assertThat(actual).isEqualTo(expected);
    }

}
