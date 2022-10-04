package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationResultTest {

    @DisplayName("계산식의 결과를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2, 10", "4 / 1 * 2 - 3, 5"})
    void operate(final String input, final int result) {

        final Expression expression = new Expression(input);
        final Expressions expressions = new Expressions(expression);
        final CalculationResult calculationResult = CalculationResult.init();

        calculationResult.calculate(expressions);

        assertThat(calculationResult.findLast()).isEqualTo(result);
    }
}