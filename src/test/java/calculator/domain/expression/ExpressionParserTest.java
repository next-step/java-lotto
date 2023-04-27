package calculator.domain.expression;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("입력문자열 파싱 테스트")
class ExpressionParserTest {
    @Test
    void 입력문자열이_NULL_이면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> ExpressionParser.of(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No calculation expression has been entered");
    }

    @Test
    void 입력문자열이_공백이면_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> ExpressionParser.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("No calculation expression has been entered");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 3 * 5 / 2,4", "9 * 3,2", "7 - 5 * 3 + 4 * 3 / 3,6"}, delimiter = ',')
    void 입력문자열에_전달한_피연산자의_개수는_피연산자_객체의_사이즈와_같다(String calculationExpression, Integer expected) {
        ExpressionParser parser = ExpressionParser.of(calculationExpression);
        Operands operands = parser.extractOperands();
        Assertions.assertThat(operands.getNumberOfOperands()).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A + B - C", "C * P / E", "APPLE / BANANA"})
    void 입력문자열에_숫자_피연산자가_없으면_예외가_발생한다(String calculationExpression) {
        Assertions.assertThatThrownBy(() -> ExpressionParser.of(calculationExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid calculation expression");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ^ 2 $ C", "1 * ! 6 = 9", "1004 ? 2"})
    void 입력문자열에_정의된_산술연산자가가_없으면_예외가_발생한다(String calculationExpression) {
        Assertions.assertThatThrownBy(() -> ExpressionParser.of(calculationExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid calculation expression");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 9 - 2 +", "8 * 3 / 4 7", "1004 + - 2"})
    void 입력문자열의_피연산자의_개수는_반드시_산술연산자보다_1개_많아야한다(String calculationExpression) {
        Assertions.assertThatThrownBy(() -> ExpressionParser.of(calculationExpression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid calculation expression");
    }



}