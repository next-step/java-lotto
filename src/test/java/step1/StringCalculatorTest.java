package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step1.domain.Expression;
import step1.domain.Operand;
import step1.domain.Operator;
import step1.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            boolean result = InputView.isValidInputFormat(input);
            assertTrue(result);
            return;
        }

        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.isValidInputFormat(input))
                .withMessage(expectedMessage);
    }

    @Test
    public void testGetOperands() {
        String expression = "2 + 3 * 4 / 2";
        List<Operand> operands = Expression.getOperands(expression);
        List<Operand> expected = List.of(new Operand(2), new Operand(3), new Operand(4), new Operand(2));

        assertEquals(expected, operands, "Operands should match the expected values.");
    }

    @Test
    public void testGetOperators() {
        String expression = "2 + 3 * 4 / 2";
        List<Operator> operators = Expression.getOperators(expression);

        List<String> expected = List.of("+", "*", "/");
        List<String> actual = operators.stream()
                .map(Operator::getSymbol)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }


    @Test
    public void testAdd() {
        // StringCalculator.add(1+3-2) = 2
    }

    @Test
    public void testSubtract() {
        // StringCalculator.add(3-1+2) = 4
        // StringCalculator.add(1-2-3) = -4
    }

    @Test
    public void testMultiply() {
        // StringCalculator.multiply(3*2) = 6
        // StringCalculator.multiply(3-3*7) = 0
        // StringCalculator.multiply(1-5*2) = -8
    }

    @Test
    public void testDivide() {
        // StringCalculator.divide(4/2) = 2
        // StringCalculator.divide(3/2) = 1
        // StringCalculator.divide(-5/2) = -2
        // StringCalculator.divide(0/2) = 0
        // StringCalculator.divide(2/5) = 0
    }

    @Test
    public void testGetTotalResult() {
        // StringCalculator.calculate(2 + 3 * 4 / 2) = 10
    }

}
