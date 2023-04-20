package domain;

import common.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @ParameterizedTest(name = "요청 연산자 : {0}, 반환 연산자 : {1}")
    @MethodSource("separatorAndConstantPair")
    @DisplayName("연산자 조회 테스트")
    void lookUp(String separator, Operator operator) {

        assertThat(Operator.lookUp(separator)).isEqualTo(operator);
    }

    @ParameterizedTest(name = "요청 연산자 : {0}")
    @ValueSource(strings = {"~", "$", "&", "@", "^"})
    @DisplayName("등록되지 않은 연산자 조회 테스트")
    void noSuchLookUp(String separator) {

        assertThatIllegalArgumentException().isThrownBy(() -> Operator.lookUp(separator))
                .withMessage(ErrorMessage.NO_SUCH_OPERATOR.getErrorMessage());

    }

    @ParameterizedTest(name = "leftOperand : {0} , rightOperand {1}")
    @CsvSource(value = {"1,2", "2,5", "-1,3"})
    @DisplayName("더하기 기능 테스트")
    void additionTest(int leftOperand, int rightOperand) {
        assertThat(Operator.calculate(Operator.ADDITION, leftOperand, rightOperand))
                .isEqualTo(leftOperand + rightOperand);
    }

    @ParameterizedTest(name = "leftOperand : {0} , rightOperand {1}")
    @CsvSource(value = {"1,2", "2,5", "-1,3"})
    @DisplayName("뺄셈 기능 테스트")
    void subtractionTest(int leftOperand, int rightOperand) {
        assertThat(Operator.calculate(Operator.SUBTRACTION, leftOperand, rightOperand))
                .isEqualTo(leftOperand + rightOperand);
    }

    @ParameterizedTest(name = "leftOperand : {0} , rightOperand {1}")
    @CsvSource(value = {"1,2", "2,5", "-1,3"})
    @DisplayName("곱셈 기능 테스트")
    void multiplicationTest(int leftOperand, int rightOperand) {
        assertThat(Operator.calculate(Operator.MULTIPLICATION, leftOperand, rightOperand))
                .isEqualTo(leftOperand + rightOperand);
    }

    @ParameterizedTest(name = "leftOperand : {0} , rightOperand {1}")
    @CsvSource(value = {"1,2", "2,5", "-1,3"})
    @DisplayName("나눗셈 기능 테스트")
    void divisionTest(int leftOperand, int rightOperand) {
        assertThat(Operator.calculate(Operator.DIVISION, leftOperand, rightOperand))
                .isEqualTo(leftOperand + rightOperand);
    }



    static Stream<Arguments> separatorAndConstantPair() {
        return Stream.of(
                Arguments.arguments("+", Operator.ADDITION),
                Arguments.arguments("-", Operator.SUBTRACTION),
                Arguments.arguments("*", Operator.MULTIPLICATION),
                Arguments.arguments("/", Operator.DIVISION)
        );
    }

}