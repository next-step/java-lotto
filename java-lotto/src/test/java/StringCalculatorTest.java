
import org.junit.jupiter.api.Test;
import ui.InputView;
import ui.OutputView;
import ui.StringCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator(new InputView(), new OutputView());
    String input ="";
    int result = 0;

    @Test
    public void 덧셈테스트() {
        input = "1 + 2 + 3";
        calculator.inputView.validateInput(input);
        result = calculator.calculate(input);
        calculator.outputView.printOutput(result);
        assertEquals(6, result);
    }

    @Test
    public void 뺄셈테스트() {
        input = "8 - 2 - 3";
        calculator.inputView.validateInput(input);
        result = calculator.calculate(input);
        calculator.outputView.printOutput(result);
        assertEquals(3, result);
    }

    @Test
    public void 곱셈테스트() {
        input = "5 * 2";
        calculator.inputView.validateInput(input);
        result = calculator.calculate(input);
        calculator.outputView.printOutput(result);
        assertEquals(10, result);
    }

    @Test
    public void 나눗셈테스트() {
        input = "8 / 2";
        calculator.inputView.validateInput(input);
        result = calculator.calculate(input);
        calculator.outputView.printOutput(result);
        assertEquals(4, result);
    }

    @Test
    public void 연산순서테스트() {
        input = "3 + 2 * 4";
        calculator.inputView.validateInput(input);
        result = calculator.calculate(input);
        calculator.outputView.printOutput(result);
        assertEquals(20, result);
    }


}
