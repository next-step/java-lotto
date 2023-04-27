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

@DisplayName("연산자 집합 객체 테스트")
class OperatorsTest {

    @Test
    void 문자열리스트를_전달하면_정의된_연산자_기호문자열만_추출된다() {
        List<String> expressions = Arrays.asList("3", "+", "2", "-", "1");
        Operators operators = Operators.extractOperator(expressions);
        assertThat(operators.getNumberOfOperators()).isEqualTo(2);
    }

    @Test
    void 연산자_집합이_비어있는지_확인할수있다() {
        List<String> expressions = Arrays.asList("3", "+", "2");
        Operators operators = Operators.extractOperator(expressions);
        assertThat(operators.isInValid()).isEqualTo(false);
    }

    @Test
    void 연산자_집합의_사이즈는_피연산자_집합의_사이즈보다_1개_적어야한다() {
        List<String> expressions = Arrays.asList("3", "+", "2", "-", "1");
        Operands operands = Operands.extractOperand(expressions);
        Operators operators = Operators.extractOperator(expressions);
        assertThat(operators.hasInValidSizeWithOperands(operands)).isEqualTo(false);
    }

    @ParameterizedTest
    @MethodSource("operandExtractionCases")
    void 연산자들_집합은_추출한_순서대로_꺼낼수있다(List<String> expressions, List<String> expectedOperators) {
        Operators operators = Operators.extractOperator(expressions);

        for (String expectedOperator : expectedOperators) {
            assertThat(operators.next().symbol()).isEqualTo(expectedOperator);
        }
    }

    static Stream<Arguments> operandExtractionCases() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("3", "+", "2", "-", "1"),
                        Arrays.asList("+", "-")
                ),
                Arguments.of(
                        Arrays.asList("9", "-", "3", "*", "6", "/", "4"),
                        Arrays.asList("-", "*", "/")
                )
        );
    }

}