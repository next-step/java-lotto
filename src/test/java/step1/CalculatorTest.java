package step1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    void sum() {
        Calculator calculator = new Calculator();
        int result = calculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void convert_string_to_number() {
        Calculator calculator = new Calculator();
        String[] list = {"1","2"};
        List<Number> numbers = calculator.parseNumber(list);
        assertThat(numbers).contains(new Number("1"));
    }
}
