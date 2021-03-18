package step1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        this.calculatorService = new CalculatorService();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,1:2",
            "1,2,3,4:10",
            "2,6,3,9:20"}, delimiter = ':')
    @DisplayName("덧셈을 수행할 수 있다")
    void calculatorCanAddBulk(String input, int expected) {
        assertThat(calculatorService.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"]", "1/2", "1`5"})
    @DisplayName("오류값이 있는 인풋이 들어오면 IllegalArgumentException을 던진다")
    void canThrowExceptionOnInvalidInput(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> calculatorService.calculate(input));
    }
}