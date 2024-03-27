package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParsedFormulaTest {
    @ParameterizedTest
    @CsvSource(value = {"0:4", "1:+", "2:3", "3:*", "4:12", "5:/", "6:4"}, delimiter = ':')
    @DisplayName("문자열을 입력하여 ParsedFormula 객체 생성")
    public void testParsedFormulaInitializationWithString(int input, String expected) {
        ParsedFormula parsedFormula = new ParsedFormula("4 + 3 * 12 / 4");

        if (input % 2 == 0) {
            assertThat(parsedFormula.getOperand(input)).isEqualTo(Integer.parseInt(expected));
        }

        if (input % 2 == 1) {
            assertThat(parsedFormula.getOperator(input)).isEqualTo(expected);

        }
    }

    @Test
    @DisplayName("허용된 사칙연산 기호 예외 테스트")
    public void testNotValidOperator() {
        ParsedFormula parsedFormula = new ParsedFormula("4 ^ 3");

        assertThatThrownBy(() -> parsedFormula.getOperator(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("허용된 사칙연산 기호가 아닙니다.");
    }

    @Test
    @DisplayName("허용된 피연산자(정수) 예외 테스트")
    public void testNotValidOperand() {
        ParsedFormula parsedFormula = new ParsedFormula("3.14 ^ 3");

        assertThatThrownBy(() -> parsedFormula.getOperand(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("피연산자는 정수값이어야 합니다.");
    }
}