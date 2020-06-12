package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName(",로 구분한 숫자를 더한다")
    @Test
    void sum_with_comma() {
        Calculator calculator = new Calculator();
        int result = calculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName(":로 구분한 숫자를 더한다")
    @Test
    void sum_with_colon() {
        Calculator calculator = new Calculator();
        int result = calculator.sum("1:2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("custom 구분자로 구분한 숫자를 더한다")
    @Test
    void sum_with_custom_delimiter() {
        Calculator calculator = new Calculator();
        int result = calculator.sum("//;\n1;2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("custom 구분자로 구분한 2개 이상의 숫자를 더한다")
    @Test
    void sum_with_multi_value() {
        Calculator calculator = new Calculator();
        int result = calculator.sum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("String 배열을 List<Number>로 변환한다")
    @Test
    void convert_string_to_number() {
        Calculator calculator = new Calculator();
        String[] list = {"1","2"};
        List<Number> numbers = calculator.parseNumber(list);
        assertThat(numbers).contains(new Number("1"));
    }

    @Test
    void sum_composite() {
        Calculator calculator = new Calculator();
        List<Number> numbers = Arrays.asList(Number.of(1),Number.of(2),Number.of(3));
        Number sum = calculator.sumValues(numbers);
        assertThat(sum).isEqualTo(Number.of(6));
    }
}
