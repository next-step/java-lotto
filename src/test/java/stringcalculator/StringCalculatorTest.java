package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("[요구사항 1] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
    void 요구사항_1(String input) {
        assertThatThrownBy(() -> stringCalculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값은 null 또는 빈 공백 문자일 수 없습니다.");
    }

    @Test
    @DisplayName("[요구사항 2] 사칙 연산 기호가 아닐 경우 IllegalArgumentException throw")
    void 요구사항_2() {
        // given
        final String GIVEN_INPUT = "1 . 5";

        // then
        assertThatThrownBy(() -> stringCalculator.calculate(GIVEN_INPUT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙 연산 기호가 아닌 기호는 입력 값이 될 수 없습니다.");
    }

    @Test
    @DisplayName("[요구사항 3] 덧셈 연산 기호일 경우, 덧셈 연산을 진행한다.")
    void 요구사항_3() {
        // given
        final String GIVEN_INPUT = "1 + 5";
        final int EXPECTED_RESULT = 6;

        // then
        assertThat(stringCalculator.calculate(GIVEN_INPUT)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    @DisplayName("[요구사항 4] 뺄셈 연산 기호일 경우, 뺄셈 연산을 진행한다.")
    void 요구사항_4() {
        // given
        final String GIVEN_INPUT = "1 - 5";
        final int EXPECTED_RESULT = -4;

        // then
        assertThat(stringCalculator.calculate(GIVEN_INPUT)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    @DisplayName("[요구사항 5] 곱셈 연산 기호일 경우, 곱셈 연산을 진행한다.")
    void 요구사항_5() {
        // given
        final String GIVEN_INPUT = "1 * 5";
        final int EXPECTED_RESULT = 5;

        // then
        assertThat(stringCalculator.calculate(GIVEN_INPUT)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    @DisplayName("[요구사항 6] 나눗셈 연산 기호일 경우, 나눗셈 연산을 진행하며 결과 값은 정수로 떨어진다.")
    void 요구사항_6() {
        // given
        final String GIVEN_INPUT = "1 / 5";
        final int EXPECTED_RESULT = 0;

        // then
        assertThat(stringCalculator.calculate(GIVEN_INPUT)).isEqualTo(EXPECTED_RESULT);
    }

    @Test
    @DisplayName("[요구사항 7] 입력 값에 따른 계산 순서 대로 계산이 진행된다. (사칙 연산 모두 포함)")
    void 요구사항_7() {
        // given
        final String GIVEN_INPUT = "2 + 3 * 4 / 2";
        final int EXPECTED_RESULT = 10;

        // then
        assertThat(stringCalculator.calculate(GIVEN_INPUT)).isEqualTo(EXPECTED_RESULT);
    }
}