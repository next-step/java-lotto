package step01.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.BDDAssertions.then;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "1 + 2, 3",
        "5 - 1, 4",
        "9 * 8, 72",
        "20 / 4, 5",
        "2 + 4 - 3, 3",
        "1 * 2 / 2 + 4, 5",
        "3 - 5 - 10 + 2 / 5, -2",
        "93 - 25 * 10 / 5 - 6 / 13 + 2, 12",
    })
    @DisplayName("입력한 문자열에 맞게 정상적으로 계산되는지 테스트")
    void calc(String expression, Integer result) {
        then(Calculator.calc(new Expression(expression))).isEqualTo(result);
    }
}