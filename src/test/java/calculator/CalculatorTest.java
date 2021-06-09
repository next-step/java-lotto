package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void sumNumbers() {
        List<Integer> numbers = Arrays.asList(2, 3);
        assertThat(calculator.sumNumbers(numbers)).isEqualTo(5);
    }
}
