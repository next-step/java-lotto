package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import StringCalculator.domain.Calculator;
import StringCalculator.domain.Expression;
import StringCalculator.domain.Operand;
import StringCalculator.domain.Operator;
import StringCalculator.view.InputView;

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
        assertEquals(4, Calculator.add("1", "3"));
        assertEquals(1, Calculator.add("3", "-2"));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, Calculator.subtract("3", "1"));
        assertEquals(-1, Calculator.subtract("1", "2"));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, Calculator.multiply("3", "2"));
        assertEquals(0, Calculator.multiply("3", "0"));
        assertEquals(-5, Calculator.multiply("1", "-5"));
    }

    @Test
    public void testDivide() {
        assertEquals(2, Calculator.divide("4", "2"));
        assertEquals(1, Calculator.divide("3", "2"));
        assertEquals(-2, Calculator.divide("-5", "2"));
        assertEquals(0, Calculator.divide("0", "2"));
        assertEquals(0, Calculator.divide("2", "5"));
    }

    @Test
    public void testCalculate() {
        List<Operand> operands = List.of(new Operand(2), new Operand(3), new Operand(4), new Operand(2));
        List<Operator> operators = List.of(new Operator("+"), new Operator("*"), new Operator("/"));

        int result = Calculator.calculate(operands, operators);
        assertEquals(10, result);
    }
}
