package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorFactoryTest {
    @Test
    @DisplayName("올바른 계산식을 입력하면 계산 결과를 반환한다.")
    void validExpressionTest() {
        Calculator calculator = CalculatorFactory.createCalculator("2 + 3 * 4 / 2");
        assertThat(calculator.run()).isEqualTo(new Number(10));
    }

    @Test
    @DisplayName("계산식의 숫자와 연산자가 공백으로 구분되지 않으면 오류가 발생한다.")
    void invalidExpressionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculatorFactory.createCalculator("2+3 * 4 / 2");
        });
    }

    @ParameterizedTest
    @DisplayName("입력값이 null 이거나 빈 문자열이면 오류가 발생한다.")
    @NullAndEmptySource
    void nullOrEmptyExpressionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            CalculatorFactory.createCalculator(input);
        });
    }
}
