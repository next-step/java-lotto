package step1;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    public void testInputValidation() {
        // InputView.IsValidInput(2 + 3 * 4 / 2) = true
        // InputView.IsValidInput(2 ++ 3 * 4 / 2) = false
        // InputView.IsValidInput( * 2 + 3 * 4 / 2) = false
        // InputView.IsValidInput( 2 + 3 * 4 / 2 -) = false
        // InputView.IsValidInput( 2 + 3 * 4 / 0 ) = false, "0으로 나눌 수 없습니다."
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
    }

    @Test
    public void testGetTotalResult() {
        // StringCalculator.calculate(2 + 3 * 4 / 2) = 10
    }

}
