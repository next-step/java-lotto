package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator(new StringSeparator());

    @ParameterizedTest(name = "검증한 입력이 들어왔을 때 계산하는 테스트")
    @CsvSource(value = {
            "1 + 2 + 3|6",
            "3 - 2 - 1|0",
            "1 * 2 * 3|6",
            "4 / 2 / 1|2"
    }, delimiter = '|')
    void calculatorTest_일반_계산(String input, int expected) {
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "검증한 입력이 들어왔을 때 결과값이 몫으로 나오는지 테스트")
    @CsvSource(value = {
            "3 + 2 / 3|1",
            "3 - 3 / 1|0",
            "1 / 2 * 3|0",
            "4 / 2 - 1|1"
    }, delimiter = '|')
    void calculatorTest_결과값_정수(String input, int expected) {
        int result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }
}
