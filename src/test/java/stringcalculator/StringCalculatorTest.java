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

    @Test
    @DisplayName("공백으로 구분된 입력값 배열이 3미만이면 예외가 발생한다.")
    void inputsLengthUnderThreeFailTest() {
        assertThatThrownBy(() -> StringCalculator.calculate("2 *"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개 이상이어야 합니다.");
    }

    @Test
    @DisplayName("공백으로 구분된 입력값 배열의 길이가 짝수이면 예외가 발생한다.")
    void inputsLengthEvenFailTest() {
        assertThatThrownBy(() -> StringCalculator.calculate("2 * 2 *"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("계산가능한 홀수 개수 형태로 주어져야 합니다.");
    }

    @Test
    @DisplayName("올바르지 않은 연산자가 주어지면 예외가 발생한다.")
    void inputsOperatorFailTest() {
        assertThatThrownBy(() -> StringCalculator.calculate("2 * 2 a 1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 연산자");
    }
}
