package step1.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        this.calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,1:2",
            "1,2,3,4:10",
            "2,6,3,9:20"}, delimiter = ':')
    @DisplayName("덧셈을 수행할 수 있다")
    void calculatorCanAddBulk(String input, int expected) {
        List<String> stringifiedInput = Arrays.asList(input.split(","));
        List<Integer> parsedInput = stringifiedInput.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        assertThat(calculator.addBulk(parsedInput)).isEqualTo(expected);
    }
}