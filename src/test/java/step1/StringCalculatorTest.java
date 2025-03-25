package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
            "'2 + 3 * 4 / 2', 'none'"  // 정상 케이스
    })
    public void testValidateInputFormat(String input, String expectedMessage) {
        if ("none".equals(expectedMessage)) {
            // 정상 케이스, 예외가 발생하지 않아야 함
            boolean result = InputView.isValidInputFormat(input);
            assertTrue(result);
            return;
        }

        // 유효하지 않은 입력 시, 예외 발생
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputView.isValidInputFormat(input))
                .withMessage(expectedMessage);
    }

    @Test
    public void testValidateInputValue() {
        // InputView.IsValidInputValue( 2 + a * b / 5 ) = false,  IllegalArgumentException throw -> "숫자와 사칙연산(+-*/)만 입력 가능합니다."
        // InputView.IsValidInputValue( 2 + 3 // 2^2  5 ) = false,  IllegalArgumentException throw -> "숫자와 사칙연산(+-*/)만 입력 가능합니다."
        // InputView.IsValidInputValue( 2 + 3 * 4 / 0 ) = false, IllegalArgumentException throw -> "0으로 나눌 수 없습니다."
    }

    @Test
    public void testGetOperands() {
        // InputView.getOperands(2 + 3 * 4 / 2) = [2,3,4,2]
    }

    @Test
    public void testGetOperators() {
        // InputView.getOperators(2 + 3 * 4 / 2) = [+,*,/]
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
