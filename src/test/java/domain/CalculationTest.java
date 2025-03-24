package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculationTest {

    @DisplayName("계산 테스트")
    @CsvSource(value = {
            "1 + 2, 3",
            "1 - 2, -1",
            "1 * 2, 2",
            "1 / 2, 0"
    })
    @ParameterizedTest
    void calculateTest(String formula, Integer expected) {
        Tokens tokens = new Tokens(formula);
        Calculation calculation = new Calculation(tokens);
        int result = calculation.calculate();

        Assertions.assertThat(expected).isEqualTo(result);
    }
}