package kr.heesu.calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        List<Number> numbers = Arrays.asList(1, 2, 3)
                .stream()
                .map(Number::new)
                .collect(Collectors.toList());

        Arguments args = Arguments.of(numbers);
        Expression exp = Expression.of(args);

        calculator = Calculator.of(exp);
    }

    @Test
    void calculateTest() {
        while (calculator.hasNext()) {
            calculator.calculate();
        }

        Result result = calculator.getResult();

        assertThat(result.getVal()).isEqualTo(6);
        assertThat(calculator.hasNext()).isFalse();
    }
}
