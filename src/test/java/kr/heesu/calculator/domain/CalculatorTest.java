package kr.heesu.calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3));
        Arguments args = Arguments.of(nums);
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
