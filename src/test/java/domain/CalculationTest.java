package domain;

import domain.symbol.Operand;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculationTest {

    @DisplayName("계산 테스트")
    @CsvSource(value = {
            "1, 1",
            "1 + 2, 3",
            "1 - 2, -1",
            "1 * 2, 2",
            "1 / 2, 0",
            "1 + 2 + 3, 6",
            "1 + 2 * 3, 9",
            "2 / 4 + 3, 3",
            "2 + 3 * 4 / 2, 10"
    })
    @ParameterizedTest
    void calculateTest(String formula, Integer expected) {
        Tokens tokens = new Tokens(formula);
        Calculation calculation = new Calculation(tokens);
        Operand result = calculation.calculate();

        Assertions.assertThat(result).isEqualTo(new Operand(expected));
    }

    @DisplayName("계산식이 올바르지 않을 경우 IllegalArgumentException 발생")
    @CsvSource(value = {
            "1 +",
            "+ 2",
            "1 2",
            "1 + 2 +",
            "1 + + 2",
            "1 + 2 + 3 +",
            "1 + 2 + + 3"
    })
    @ParameterizedTest
    void invalidFormulaTest(String formula) {
        Tokens tokens = new Tokens(formula);

        Assertions.assertThatThrownBy(() -> new Calculation(tokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid Formula");
    }
}