package domain.extractor;

import common.error.ErrorMessage;
import domain.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorExtractorTest {

    private Extractor<?> extractor;

    @BeforeEach
    void initialization() {
        extractor = new OperatorExtractor();
    }

    @ParameterizedTest(name = "input : {0} , operatorList {1}")
    @MethodSource("getSuccessPairValue")
    @DisplayName("연산자를 추출하는 테스트")
    void extract(List<String> input, List<Operator> operatorList) {

        assertThat(extractor.extract(input)).isEqualTo(operatorList);
    }

    @ParameterizedTest(name = "input : {0} , operatorList {1}")
    @MethodSource("getFailPairValue")
    @DisplayName("연산자를 추출 실패하는 테스트")
    void extractFail(List<String> input, List<Operator> operatorList) {
        assertThatIllegalArgumentException().isThrownBy(() -> extractor.extract(input))
                .withMessage(ErrorMessage.NO_SUCH_OPERATOR.getErrorMessage());
    }

    static Stream<Arguments> getSuccessPairValue() {

        return Stream.of(
                Arguments.of(List.of("2", "+", "3", "*", "4", "/", "2"), List.of(Operator.ADDITION, Operator.MULTIPLICATION, Operator.DIVISION)),
                Arguments.of(List.of("2", "/", "3", "*", "4", "*", "2"), List.of(Operator.DIVISION, Operator.MULTIPLICATION, Operator.MULTIPLICATION)),
                Arguments.of(List.of("2", "*", "3", "*", "4", "*", "2"), List.of(Operator.MULTIPLICATION, Operator.MULTIPLICATION, Operator.MULTIPLICATION))
        );
    }

    static Stream<Arguments> getFailPairValue() {

        return Stream.of(
                Arguments.of(List.of("2", "^", "3", "*", "4", "/", "2"), List.of(Operator.ADDITION, Operator.MULTIPLICATION, Operator.DIVISION)),
                Arguments.of(List.of("2", "/", "3", "3", "4", "*", "2"), List.of(Operator.DIVISION, Operator.MULTIPLICATION, Operator.MULTIPLICATION)),
                Arguments.of(List.of("2", "*", "3", "5", "4", "*", "2"), List.of(Operator.MULTIPLICATION, Operator.MULTIPLICATION, Operator.MULTIPLICATION))
        );
    }
}