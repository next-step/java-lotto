package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculationTest {
    @Nested
    @DisplayName("calculate() 테스트")
    class CalculateTest {
        Calculation calculation = new Calculation();

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {"1", "1 +", "1 + 1 +", "1 - +1"})
        @DisplayName("잘못된 형식의 수식을 전달하는 경우 IllegalArgumentException이 발생한다.")
        void testFailCase(String mathematicalExpression) {
            assertThatThrownBy(() -> calculation.calculate(mathematicalExpression))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @CsvSource(value = {"1 + 1:2", "1 + -1:0", "1 * -2 + 5 * 3 / 4:2", "2 + 3 * 4 / 2:10", "15 / 2:7", "1 / 2:0"}, delimiter = ':')
        @DisplayName("수식에 따른 연산 결과를 반환한다. 사칙연산의 계산 우선순위가 아닌 입력` 값에 따라 계산 순서가 결정된다.")
        void testSuccess(String mathematicalExpression, double expected) {
            assertThat(calculation.calculate(mathematicalExpression)).isEqualTo(expected);
        }
    }
}
