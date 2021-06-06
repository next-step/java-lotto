package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void sumNumbers() {
        List<Integer> numbers = Arrays.asList(2, 3);
        assertThat(calculator.sumNumbers(numbers)).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2,3", "//;/n1;2;3"})
    void sumExpression(String input) {
        assertThat(calculator.sumExpression(input)).isEqualTo(6);
    }
}
