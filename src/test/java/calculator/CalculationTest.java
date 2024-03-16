package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculationTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1", "1 +", "1 + 1 +"})
    void testInstanceCreationFail(String mathematicalExpression) {
        assertThatThrownBy(() -> Calculation.newCalculation(mathematicalExpression))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2", "1 + -1:0", "1 * -2 + 5 * 3 / 4:2", "2 + 3 * 4 / 2:10", "15 / 2:7", "1 / 2:0"}, delimiter = ':')
    @DisplayName("수식에 따른 연산 결과를 반환한다. 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.")
    void testCalculate(String mathematicalExpression, double expected) {
        Calculation calculation = Calculation.newCalculation(mathematicalExpression);
        assertThat(calculation.calculate()).isEqualTo(expected);
    }
}