package calculator;

import calculator.domain.ExpressionParser;
import calculator.domain.operator.Divide;
import calculator.domain.operator.Minus;
import calculator.domain.operator.Multiple;
import calculator.domain.operator.Plus;
import calculator.view.CalculatorInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ExpressionParserTest {

    @Test
    @DisplayName("단일 숫자만 입력된 케이스")
    void parse_one() {
        String input = "1";

        CalculatorInput calculatorInput = new ExpressionParser(input).parseOperator();

        assertThat(calculatorInput.getInit()).isEqualTo(1);
    }

    @Test
    @DisplayName("모든 종류의 연산자가 입력된 수식")
    void parse() {
        String input = "1 + 45 * 2 - 13 / 5";

        CalculatorInput calculatorInput = new ExpressionParser(input).parseOperator();

        assertThat(calculatorInput.getInit()).isEqualTo(1);
        assertThat(calculatorInput.getOperators())
                .containsExactly(
                        new Plus(45),
                        new Multiple(2),
                        new Minus(13),
                        new Divide(5)
                );
    }

    @Test
    @DisplayName("잘못된 연산자")
    void parse_wrong_operator() {
        String input = "1 $ 45 * 2 - 13 / 5";

        assertThatIllegalArgumentException().isThrownBy(() -> new ExpressionParser(input).parseOperator())
                .withMessageContaining("사칙연산 기호가 아닌 연산자");
    }

    @Test
    @DisplayName("잘못된 입력 순서")
    void parse_wrong_sequence() {
        String input = "1 55";

        assertThatIllegalArgumentException().isThrownBy(() -> new ExpressionParser(input).parseOperator())
                .withMessageContaining("수식이 올바르지 않습니다");
    }
}
