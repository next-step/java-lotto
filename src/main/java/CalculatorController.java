import java.io.PrintStream;
import java.util.Scanner;

public class CalculatorController {

    private final InputView inputView;
    private final ResultView resultView;

    public CalculatorController(Scanner scanner, PrintStream printStream) {
        this.inputView = new InputView(scanner, printStream);
        this.resultView = new ResultView(printStream);
    }

    public static CalculatorController of(Scanner scanner, PrintStream printStream) {
        return new CalculatorController(scanner, printStream);
    }

    public void calculate(){
        String postfixString = Postfix.of(inputView.calculatorString()).postfixString();
        CalculatorExpression expression = Calculator.calculate(postfixString);
        resultView.calculateResult(expression.calculate());
    }
}
