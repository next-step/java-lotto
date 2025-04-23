import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stringCalculator.domain.Expression;
import stringCalculator.domain.Operand;
import stringCalculator.domain.Operator;

import java.util.List;
import java.util.stream.Collectors;

import static stringCalculator.domain.Expression.isInvalidInputFormat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "'', '계산식을 입력해 주세요.(e.g.2 + 3 * 4 / 2)'",
            "' ', '계산식을 입력해 주세요.(e.g.2 + 3 * 4 / 2)'",
            "'2 ++ 3 * 4 / 2', '제대로 된 형식으로 입력해 주세요.(e.g.2 + 3 * 4 / 2)'",
            "'* 2 + 3 * 4 / 2', '제대로 된 형식으로 입력해 주세요.(e.g.2 + 3 * 4 / 2)'",
            "'2 + 3 * 4 / 2 -', '제대로 된 형식으로 입력해 주세요.(e.g.2 + 3 * 4 / 2)'",
            "'2 + a * b / 5', '제대로 된 형식으로 입력해 주세요.(e.g.2 + 3 * 4 / 2)'",
            "' 2 + 3 // 2^2  5', '제대로 된 형식으로 입력해 주세요.(e.g.2 + 3 * 4 / 2)'",
            "'2 + 3 * 4 / 2', 'none'"  // 정상 케이스
    })
    public void testValidateInputFormat(String input, String expectedMessage) {
        if ("none".equals(expectedMessage)) {
            boolean result = isInvalidInputFormat(input);
            assertTrue(result);
            return;
        }

        assertThatIllegalArgumentException()
                .isThrownBy(() -> isInvalidInputFormat(input))
                .withMessage(expectedMessage);
    }

    @Test
    public void testGetOperands() {
        String expression = "2 + 3 * 4 / 2";
        List<Operand> operands = Expression.parseOperands(expression);
        List<Operand> expected = List.of(new Operand(2), new Operand(3), new Operand(4), new Operand(2));

        assertEquals(expected, operands, "Operands should match the expected values.");
    }

    @Test
    public void testGetOperators() {
        String input = "2 + 3 * 4 / 2";
        List<Operator> operators = Expression.parseOperators(input);

        List<String> expected = List.of("+", "*", "/");
        List<String> actual = operators.stream()
                .map(Operator::getSymbol)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }
}
