package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class StringCalculatorTest {

    private final StringCalculator calculator = StringCalculator.getInstance();

    @Test
    @DisplayName("calculate 메소드는 주어진 식을 계산하고 그 결과를 반환한다.")
    void calculate() {
        String[] tokens = {"2", "+", "3", "*", "4", "/", "2"};

        assertThat(calculator.calculate(tokens)).isEqualTo(10);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null이나 빈 값을 넘기는 경우 계산에 실패한다.")
    void failToCalculate_withNullOrEmptyValue(final String[] value) {
        assertThatThrownBy(() -> calculator.calculate(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("문자열이 누락되었습니다.");
    }

    @Test
    @DisplayName("배열 길이가 3 미만인 경우 온전하지 않은 식이라 보고 계산에 실패한다.")
    void failToCalculate_withWrongValue() {
        String[] value = {"2", "+"};

        assertThatThrownBy(() -> calculator.calculate(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("계산할 수 없는 식입니다.");
    }
}
