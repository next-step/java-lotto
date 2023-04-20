package domain;

import common.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperandTest {

    @ParameterizedTest(name = "요청 연산자 : {0}, 반환 연산자 : {1}")
    @MethodSource("separatorAndConstantPair")
    @DisplayName("연산자 조회 테스트")
    void lookUp(String separator, Operand operand) {

        assertThat(Operand.lookUp(separator)).isEqualTo(operand);
    }

    @ParameterizedTest(name = "요청 연산자 : {0}")
    @ValueSource(strings = {"~", "$", "&", "@", "^"})
    @DisplayName("등록되지 않은 연산자 조회 테스트")
    void noSuchLookUp(String separator) {

        assertThatIllegalArgumentException().isThrownBy(() -> Operand.lookUp(separator))
                .withMessage(ErrorMessage.NO_SUCH_OPERATOR.getErrorMessage());

    }

    static Stream<Arguments> separatorAndConstantPair() {
        return Stream.of(
                Arguments.arguments("+", Operand.ADDITION),
                Arguments.arguments("-", Operand.SUBTRACTION),
                Arguments.arguments("*", Operand.MULTIPLICATION),
                Arguments.arguments("/", Operand.DIVISION)
        );
    }

}