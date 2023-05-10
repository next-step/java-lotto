package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @Test
    void plus() {
        Operation operation = Operation.of(1, 3, "+");
        assertThat(operation.calculate())
                .isEqualTo(4);
    }

    @Test
    void minus() {
        Operation operation = Operation.of(3, 1, "-");
        assertThat(operation.calculate())
                .isEqualTo(2);
    }

    @Test
    void multiply() {
        Operation operation = Operation.of(2, 4, "*");
        assertThat(operation.calculate())
                .isEqualTo(8);
    }

    @Test
    void divide() {
        Operation operation = Operation.of(8, 4, "/");
        assertThat(operation.calculate())
                .isEqualTo(2);
    }
}
