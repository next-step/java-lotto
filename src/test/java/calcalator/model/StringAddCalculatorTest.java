package calcalator.model;

import calcalator.strategy.CustomDelimiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class StringAddCalculatorTest {


    private Numbers numbers;

    @BeforeEach
    void setUp() {
        List<Number> numbers = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            numbers.add(new Number(i));
        }
        this.numbers = new Numbers(numbers);

    }

    @Test
    @DisplayName("결과")
    void result() {
        StringAddCalculator calculator = new StringAddCalculator("//;\n1;2;3", new CustomDelimiter());
        Number result = calculator.result();
        assertThat(result).isEqualTo(new Number(6));
    }
}