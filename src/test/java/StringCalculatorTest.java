import calculator.StringCalculator;
import calculator.UserInput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    private final StringCalculator calculator = new StringCalculator();

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "1 + 2, 3",
            "1 + 2 + 3, 6"
    })
    void addTest(String input, double result) {
        UserInput userInput = UserInput.fromStringInput(input);
        assertThat(calculator.calculate(userInput)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "2 - 1, 1",
            "5 - 2 - 1, 2"
    })
    void subtractTest(String input, double result) {
        UserInput userInput = UserInput.fromStringInput(input);
        assertThat(calculator.calculate(userInput)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "2 * 3, 6",
            "2 * 3 * 5, 30"
    })
    void multiplyTest(String input, double result) {
        UserInput userInput = UserInput.fromStringInput(input);
        assertThat(calculator.calculate(userInput)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "4 / 2, 2",
            "42 / 7 / 2, 3"
    })
    void divideTest(String input, double result) {
        UserInput userInput = UserInput.fromStringInput(input);
        assertThat(calculator.calculate(userInput)).isEqualTo(result);
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({
            "2 + 3 * 4 / 2, 10",
            "4 + 2 * 5 - 3 / 9, 3"
    })
    void multiCalculateTest(String input, double result) {
        UserInput userInput = UserInput.fromStringInput(input);
        assertThat(calculator.calculate(userInput)).isEqualTo(result);
    }
}
