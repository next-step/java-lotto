package StringCalculator.backend.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSentenceTest {

    @DisplayName("빈 값이 들어왔을 경우 에러")
    @ParameterizedTest
    @NullAndEmptySource
    void string_null_check(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new NumberSentence(input));
    }

    @DisplayName("숫자가 비였을 경우 에러")
    @ParameterizedTest(name = "[{index}] {0} have empty operand or operater")
    @CsvSource({"1 +   - 4 - 3", "  + 8 % 2"})
    void element_null_check(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new NumberSentence(input).findOperand());
    }

    @Test
    @DisplayName("숫자 분리")
    void find_operand() {
        NumberSentence numberSentence = new NumberSentence("3 * 10 / 2 - 1");
        List<Operand> operands = numberSentence.findOperand();
        assertThat(operands).hasSize(4)
                .contains(new Operand(3),
                        new Operand(10),
                        new Operand(2),
                        new Operand(1));
    }

    @Test
    @DisplayName("연산자 분리")
    void find_operator() {
        NumberSentence numberSentence = new NumberSentence("3 * 10 / 2 - 1");
        List<Operator> operators = numberSentence.findOperator();
        assertThat(operators).hasSize(3)
                .contains(OperatorFactory.getOperator("*"),
                        OperatorFactory.getOperator("/"),
                        OperatorFactory.getOperator("-"));
    }
}
