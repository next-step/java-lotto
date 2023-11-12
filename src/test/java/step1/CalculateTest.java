package step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculateTest {

    private final InputParser inputParser = new InputParser();

    @ParameterizedTest
    @CsvSource(value = {"1 + 3 - 2:2", "5 * 2 - 5:5", "4 - 2 * 7 / 2:7"}, delimiter = ':')
    public void 사칙연산_혼합_테스트(String userInput, int expected) {
        List<String> tokens = inputParser.splitUserInput(userInput);
        Calculator calculator = new Calculator(inputParser.parseFromTokenToNumber(tokens),
                inputParser.parseFromTokenToOperator(tokens));

        assertThat(calculator.calculate()).isEqualTo(expected);
    }
}
