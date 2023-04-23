package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @Test
    @DisplayName("1 + 2 = 3")
    void addTest() {
        int result = Calculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("1 - 2 = -1")
    void subtractTest() {
        int result = Calculator.calculate("1 - 2");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("1 * 2 = 2")
    void multiplyTest() {
        int result = Calculator.calculate("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("3 / 2 = 1")
    void divideTest() {
        int result = Calculator.calculate("3 / 2");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("2 + 3 * 4 / 2 = 10")
    void complexTest() {
        int result = Calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("parse error: 1 + 2 +")
    void parseErrorTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Calculator.calculate("1 + 2 +"))
            .withMessage("Invalid expression: 1 + 2 +");
    }

    @Test
    @DisplayName("parse error: empty input")
    void emptyInputTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Calculator.calculate(""))
            .withMessage("Input cannot be empty");
    }
    @Test
    @DisplayName("parse error: null input")
    void nullInputTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Calculator.calculate(null))
            .withMessage("Input cannot be empty");
    }

    @Test
    @DisplayName("parse error: 1 + 2 +3")
    void parseErrorTest2() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Calculator.calculate("1 + 2 +3"))
            .withMessage("Invalid expression: 1 + 2 +3");
    }
}
