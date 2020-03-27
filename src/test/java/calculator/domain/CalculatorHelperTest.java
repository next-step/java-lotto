package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorHelperTest {
    @Test
    void findNumber1() {
        List<String> numbers = CalculatorHelper.findNumber("//;\\n1;2;3");

        assertThat(numbers).hasSize(3);
        assertThat(numbers.get(0)).isEqualTo("1");
        assertThat(numbers.get(2)).isEqualTo("3");
    }

    @Test
    void findNumber2() {
        List<String> numbers = CalculatorHelper.findNumber("1");

        assertThat(numbers).hasSize(1);
        assertThat(numbers.get(0)).isEqualTo("1");
    }

    @Test
    void findNumber3() {
        List<String> numbers = CalculatorHelper.findNumber("1,2:3");

        assertThat(numbers).hasSize(3);
        assertThat(numbers.get(0)).isEqualTo("1");
        assertThat(numbers.get(1)).isEqualTo("2");
        assertThat(numbers.get(2)).isEqualTo("3");
    }
}
