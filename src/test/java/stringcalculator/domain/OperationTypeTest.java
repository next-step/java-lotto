package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperationTypeTest {

    @Nested
    @DisplayName("연산자 정상 동작 테스트")
    class SuccessCondition {
        @ParameterizedTest
        @CsvSource(value = {"+:PLUS", "-:MINUS", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
        @DisplayName("연산자에 해당하는 문자열을 입력하면 해당 연산자의 Enum을 반환한다.")
        void getOperator(String inputString, OperationType expected) {
            assertThat(OperationType.getOperator(inputString)).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("연산자 실패 테스트")
    class FailCondition {
        @ParameterizedTest
        @CsvSource(value = {"PLUS:5:3:8", "MINUS:5:3:2", "MULTIPLY:2:2:4", "DIVIDE:4:2:2"}, delimiter = ':')
        @DisplayName("숫자 2개를 넣고 연산자 타입을 통해 계산하면 해당하는 연산타입에 따른 결과가 나온다.(ex 1 + 1 = 2)")
        void calculate(OperationType operationType, int num1, int num2, int expected) {
            int result = operationType.calculate(num1, num2);
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("연산자 타입에 없는 연산자를 찾을 경우 오류가 발생한다.")
        void getOperatorFail() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> OperationType.getOperator("가"))
                    .withMessage("해당하는 연산자가 존재하지 않습니다.");
        }
    }
}