package calculator.domain.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("피연산자 집합 객체 테스트")
class OperandsTest {

    @Test
    void 문자열리스트를_전달하면_피연산자에_맞는_문자열만_추출된다() {
        List<String> expressions = Arrays.asList("3", "+", "2", "-", "1");
        Operands operands = Operands.extractOperand(expressions);
        assertThat(operands.getNumberOfOperands()).isEqualTo(3);
    }

    @Test
    void 피연산자_집합이_비어있는지_확인할수있다() {
        List<String> expressions = Arrays.asList("3", "+", "2");
        Operands operands = Operands.extractOperand(expressions);
        assertThat(operands.isInValid()).isEqualTo(false);
    }

    @ParameterizedTest
    @MethodSource("operandExtractionCases")
    void 피연산자들_집합은_추출한_순서대로_꺼낼수있다(List<String> expressions, List<Integer> expectedOperands) {
        Operands operands = Operands.extractOperand(expressions);

        for (Integer expectedOperand : expectedOperands) {
            assertThat(operands.next().toInt()).isEqualTo(expectedOperand);
        }
    }

    static Stream<Arguments> operandExtractionCases() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("3", "+", "2", "-", "1"),
                        Arrays.asList(3, 2, 1)
                ),
                Arguments.of(
                        Arrays.asList("9", "-", "3", "*", "6", "/", "4"),
                        Arrays.asList(9, 3, 6, 4)
                        )

        );
    }
}