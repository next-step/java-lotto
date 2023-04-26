package calculator.operation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationsTest {

    @ParameterizedTest
    @CsvSource(value = {"1 2 3", "-1 2 1", "0 1 1"}, delimiter = ' ')
    public void add(int x, int y, int expected) {
        int result = Operations.ADD.apply(x, y);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 -1", "-1 2 -3", "4 1 3"}, delimiter = ' ')
    public void subtract(int x, int y, int expected) {
        int result = Operations.SUBTRACT.apply(x, y);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 2", "-1 2 -2", "4 3 12"}, delimiter = ' ')
    public void multiply(int x, int y, int expected) {
        int result = Operations.MULTIPLY.apply(x, y);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 2 0", "2 -1 -2", "4 1 4"}, delimiter = ' ')
    public void divide(int x, int y, int expected) {
        int result = Operations.DIVIDE.apply(x, y);
        assertThat(result).isEqualTo(expected);
    }
}