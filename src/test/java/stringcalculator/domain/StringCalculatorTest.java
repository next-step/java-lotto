package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {

    @Nested
    @DisplayName("정상적인 문자열 연산 테스트")
    class SuccessCondition {
        @Test
        @DisplayName("정상적인 연산 문자열을 입력할 경우 정상적인 연산 결과를 반환한다.")
        void calculate() {
            StringCalculator stringCalculator = new StringCalculator("1 + 1 + 3 + 1");

            assertThat(stringCalculator.calculate()).isEqualTo(6);
        }
    }

    @Nested
    @DisplayName("문자열 연산 실패 테스트")
    class FailCondition {
        @Test
        @DisplayName("연산 문자열 중간에 공백을 기준으로 연산자가 연속될 경우 오류가 발생한다.")
        void calculate_연산연속() {
            StringCalculator stringCalculator = new StringCalculator("1 + + 3 + 1");

            assertThatIllegalArgumentException()
                    .isThrownBy(stringCalculator::calculate)
                    .withMessage("숫자 형식이 아닙니다.");
        }

        @Test
        @DisplayName("연산 문자열 중간에 공백을 기준으로 숫자가 연속될 경우 오류가 발생한다.")
        void calculate_숫자연속() {
            StringCalculator stringCalculator = new StringCalculator("1 + 1  3 + 1");

            assertThatIllegalArgumentException()
                    .isThrownBy(stringCalculator::calculate)
                    .withMessage("해당하는 연산자가 존재하지 않습니다.");
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("null이거나 비어있는 연산 문자열을 입력할 경우 오류가 발생한다.")
        void calculate_null_empty(String inputString) {
            StringCalculator stringCalculator = new StringCalculator(inputString);

            assertThatIllegalArgumentException()
                    .isThrownBy(stringCalculator::calculate)
                    .withMessage("비어 있는 값은 입력할 수 없습니다.");
        }
    }
}