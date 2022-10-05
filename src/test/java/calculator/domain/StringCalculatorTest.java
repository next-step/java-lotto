package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {

    @ParameterizedTest
    @DisplayName("계산기 사칙연산 실행 검증")
    @CsvSource(
            delimiter = ':',
            value = {
                    "5 + 10 + 20:35",
                    "-10 + 25 - 30:-15",
                    "10 + 15 - 5 * 3:60",
                    "30 - 15 + 10 / 5 * 3:15"
            }
    )
    void calculateExpression(String expression, int expected) {
        Assertions.assertThat(new StringCalculator().calculate(expression)).isEqualTo(expected);
    }
}
