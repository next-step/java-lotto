package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 사칙연산 계산기 테스트")
public class StringCalculatorTest {

    @Test
    @DisplayName("문자열을 입력받아 계산한 후 결과를 출력한다.")
    void StringCalculatorTest() {
        int result = StringCalculator.calculate("2 + 3 * 4 / 2");

        assertThat(result).isEqualTo(10);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("입력 값이 null 이 들어오면 NullPointerException 예외가 발생한다.")
    void inputNullTest(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("입력값은 null 일 수 없습니다.");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("입력 값이 빈 문자열이 들어오면 IllegalArgumentException 예외가 발생한다.")
    void inputEmptyTest(String input) {
        assertThatThrownBy(() -> StringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 빈 문자열일 수 없습니다.");
    }
}
