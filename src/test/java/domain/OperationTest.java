package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperationTest {

    @Test
    @DisplayName("parse: +")
    void fromStringAddition() {
        Operation operation = Operation.fromString("+");
        Assertions.assertThat(operation).isEqualTo(Operation.ADDITION);
    }

    @Test
    @DisplayName("parse: -")
    void fromStringSubtraction() {
        Operation operation = Operation.fromString("-");
        Assertions.assertThat(operation).isEqualTo(Operation.SUBTRACTION);
    }

    @Test
    @DisplayName("parse: *")
    void fromStringMultiplication() {
        Operation operation = Operation.fromString("*");
        Assertions.assertThat(operation).isEqualTo(Operation.MULTIPLICATION);
    }

    @Test
    @DisplayName("parse: /")
    void fromStringDivision() {
        Operation operation = Operation.fromString("/");
        Assertions.assertThat(operation).isEqualTo(Operation.DIVISION);
    }

    @Test
    @DisplayName("parse error: null input")
    void fromStringNull() {
        Assertions.assertThatThrownBy(() -> Operation.fromString(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid operator: null");
    }

    @Test
    @DisplayName("parse error: empty input")
    void fromStringEmpty() {
        Assertions.assertThatThrownBy(() -> Operation.fromString(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid operator: ");
    }

    @Test
    @DisplayName("parse error: invalid input")
    void fromStringInvalid() {
        Assertions.assertThatThrownBy(() -> Operation.fromString("invalid"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid operator: invalid");
    }
}
