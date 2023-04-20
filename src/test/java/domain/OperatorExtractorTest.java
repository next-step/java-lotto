package domain;

import domain.extractor.Extractor;
import domain.extractor.OperatorExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorExtractorTest {

    private Extractor<?> extractor;

    @BeforeEach
    void initialization() {
        extractor = new OperatorExtractor();
    }

    @ParameterizedTest(name = "input : {0} , operatorList {1}")
    @MethodSource("getSuccessPairValue")
    @DisplayName("연산자를 추출하는 테스트")
    void extract(List<String> input,List<Operator> operatorList) {

         assertThat(extractor.extract(input)).isEqualTo(operatorList);
    }

    static Stream<Arguments> getSuccessPairValue() {

        return Stream.of(
                Arguments.of(List.of("2", "+", "3", "*", "4", "/", "2"), List.of(Operator.ADDITION, Operator.MULTIPLICATION, Operator.DIVISION)),
                Arguments.of(List.of("2", "/", "3", "*", "4", "*", "2"), List.of(Operator.DIVISION, Operator.MULTIPLICATION, Operator.MULTIPLICATION)),
                Arguments.of(List.of("2", "*", "3", "*", "4", "*", "2"), List.of(Operator.MULTIPLICATION, Operator.MULTIPLICATION, Operator.MULTIPLICATION))
        );
    }
}