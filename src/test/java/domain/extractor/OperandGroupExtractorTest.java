package domain.extractor;

import calculator.domain.extractor.Extractor;
import calculator.domain.extractor.OperandExtractor;
import calculator.error.ErrorMessage;
import calculator.domain.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperandGroupExtractorTest {
    private Extractor<?> extractor;

    @BeforeEach
    void initialization() {
        extractor = new OperandExtractor();
    }

    @ParameterizedTest(name = "input : {0} , operatorList {1}")
    @MethodSource("getSuccessPairValue")
    @DisplayName("피연산자를 추출하는 테스트")
    void extract(List<String> input, List<Operator> operatorList) {

        assertThat(extractor.extract(input)).isEqualTo(operatorList);
    }

    static Stream<Arguments> getSuccessPairValue() {

        return Stream.of(
                Arguments.of(List.of("2", "+", "3", "*", "4", "/", "2"), List.of(2, 3, 4, 2)),
                Arguments.of(List.of("2", "/", "1", "*", "5", "*", "3"), List.of(2, 1, 5, 3)),
                Arguments.of(List.of("2", "*", "3", "*", "1", "*", "0"), List.of(2, 3, 1, 0))
        );
    }

    @ParameterizedTest(name = "input : {0} ")
    @MethodSource("getFailPairValue")
    @DisplayName("피연산자를 추출 실패하는 테스트")
    void extractFail(List<String> input) {
        assertThatIllegalArgumentException().isThrownBy(() -> extractor.extract(input))
                .withMessage(ErrorMessage.NO_SUCH_OPERAND.getErrorMessage());
    }

    static Stream<Arguments> getFailPairValue() {

        return Stream.of(
                Arguments.of(List.of("*", "^", "3", "*", "4", "/", "2")),
                Arguments.of(List.of(",", "/", "3", "3", "4", "*", "2")),
                Arguments.of(List.of("#", "*", "3", "5", "4", "*", "2"))
        );
    }
}