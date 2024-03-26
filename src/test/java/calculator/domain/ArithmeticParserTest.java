package calculator.domain;

import static calculator.config.CalculatorExceptionMessage.EXPRESSION_TEXT_CANNOT_BE_NULL_OR_BLANK;
import static calculator.config.CalculatorExceptionMessage.EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.domain.parser.ArithmeticParser;
import calculator.domain.parser.Parser;

class ArithmeticParserTest {

    private final Parser parser = new ArithmeticParser();

    @ParameterizedTest
    @NullSource
    @DisplayName("계산식 문자열이 null인 경우 예외를 던진다.")
    void Parse_NullText_Exception(final String nullText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parse(nullText))
                .withMessage(EXPRESSION_TEXT_CANNOT_BE_NULL_OR_BLANK.message(nullText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     ", "\n", " \n"})
    @DisplayName("계산식 문자열이 빈 문자열, 공백, 개행인 경우 예외를 던진다.")
    void Parse_BlankText_Exception(final String blankText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parse(blankText))
                .withMessage(EXPRESSION_TEXT_CANNOT_BE_NULL_OR_BLANK.message(blankText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + + 5", "2 2 + 5", "2 - 1 1 / / 5"})
    @DisplayName("계산식 문자열에 피연산자와 연산자가 번갈아가며 나열되지 않은 경우 예외를 던진다.")
    void Parse_OperandAndOperatorNotTakeTurn_Exception(final String expressionText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parse(expressionText))
                .withMessage(EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN.message(expressionText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+ 5", "5 +", "5 + 4 -", "/ 3 - 4", "5 + 4 - 1 *"})
    @DisplayName("계산식 문자열의 시작과 끝 요소가 피연산자가 아닌 경우 예외를 던진다.")
    void Parse_TextStartAndEndAreNotOperand_Exception(final String expressionText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parse(expressionText))
                .withMessage(EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN.message(expressionText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2+ 5", "2 +5", "2+5", "2 - 5 /3", "3/ 4 - 1", "4 + 5 / 1 -2"})
    @DisplayName("계산식 문자열의 요소 사이에 공백이 없는 경우 예외를 던진다.")
    void Parse_NoWhiteSpaceBetweenOperandAndOperator_Exception(final String expressionText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parse(expressionText))
                .withMessage(EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN.message(expressionText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2  + 5", "2 +  5", "2  +  5", "4 -     1 / 5", "1 - 3 / 2   + 1"})
    @DisplayName("계산식 문자열의 요소 사이에 두 칸 이상의 공백이 있는 경우 예외를 던진다.")
    void Parse_MoreThanSingleWhiteSpaceBetweenOperandAndOperator_Exception(final String expressionText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parse(expressionText))
                .withMessage(EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN.message(expressionText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a + 1", "1 + a", "1a + 1", "1 + 1a", "a + b", "2.5 * 1", "3^2 / 2 + 1"})
    @DisplayName("계산식 문자열의 피연산자가 정수형이 아닌 경우 예외를 던진다.")
    void Parse_OperandNotIntegerFormat_Exception(final String expressionText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parse(expressionText))
                .withMessage(EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN.message(expressionText));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 % 2", "1 $ 2", "1 @ 2", "1 + 2 # 3", "1 // 2 + 4"})
    @DisplayName("계산식 문자열의 연산자가 사칙연산 기호(+, -, *, /) 중 하나가 아닌 경우 예외를 던진다.")
    void Parse_OperatorNotArithmeticSymbol_Exception(final String expressionText) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> parser.parse(expressionText))
                .withMessage(EXPRESSION_TEXT_SHOULD_FOLLOW_PATTERN.message(expressionText));
    }
}
