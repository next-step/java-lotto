package service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    private InputValueParser inputValueParser;
    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "2 + 3:5", "3 + 5:8"}, delimiter = ':')
    @DisplayName("덧셈 실행시 기대값 출력되는지 확인")
    void plusCalculateTest(String inputValue, int expect) {

        inputValueParser = new InputValueParser(inputValue);

        int result = calculator.calculateInputValue(inputValueParser);

        assertThat(result).isEqualTo(expect);

    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 2:-1", "2 - 3:-1", "3 - 5:-2"}, delimiter = ':')
    @DisplayName("뺄셈 실행시 기대값 출력되는지 확인")
    void minusCalculateTest(String inputValue, int expect) {

        inputValueParser = new InputValueParser(inputValue);

        int result = calculator.calculateInputValue(inputValueParser);

        assertThat(result).isEqualTo(expect);

    }

    @ParameterizedTest
    @CsvSource(value = {"1 * 2:2", "2 * 3:6", "3 * 5:15"}, delimiter = ':')
    @DisplayName("곱셈 실행시 기대값 출력되는지 확인")
    void multiplyCalculateTest(String inputValue, int expect) {

        inputValueParser = new InputValueParser(inputValue);

        int result = calculator.calculateInputValue(inputValueParser);

        assertThat(result).isEqualTo(expect);

    }

    @ParameterizedTest
    @CsvSource(value = {"1 / 2:0", "4 / 4:1", "3 / 0:0"}, delimiter = ':')
    @DisplayName("나눗셈 실행시 기대값 출력되는지 확인")
    void divideCalculateTest(String inputValue, int expect) {

        inputValueParser = new InputValueParser(inputValue);

        int result = calculator.calculateInputValue(inputValueParser);

        assertThat(result).isEqualTo(expect);

    }

}