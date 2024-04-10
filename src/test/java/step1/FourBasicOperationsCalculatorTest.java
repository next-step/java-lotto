package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class FourBasicOperationsCalculatorTest {

    FourBasicOperationsCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new FourBasicOperationsCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "2 + 3:5", "3 + 4:7"}, delimiter = ':')
    @DisplayName("덧셈")
    void addition(String question, int result) {
        calculator.calculate(question);
        assertThat(calculator.result()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 - 1:0", "1 - 2:-1", "2 - 1:1"}, delimiter = ':')
    @DisplayName("뺄셈")
    void substraction(String question, int result) {
        calculator.calculate(question);
        assertThat(calculator.result()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * -1:-2", "2 * 0:0", "2 * 1:2"}, delimiter = ':')
    @DisplayName("곱셈")
    void multiplication(String question, int result) {
        calculator.calculate(question);
        assertThat(calculator.result()).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 / 1:4", "4 / 2:2", "4 / 4:1"}, delimiter = ':')
    @DisplayName("나눗셈")
    void division(String question, int result) {
        calculator.calculate(question);
        assertThat(calculator.result()).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ! 2", "2 @ 3", "4 # 5"})
    @DisplayName("사칙연산 기호 아님")
    void notFourBasicOperations(String question) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(question));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "   "})
    @DisplayName("null 또는 공백")
    void nullOrEmptyInput(String question) {
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(question));
    }

}