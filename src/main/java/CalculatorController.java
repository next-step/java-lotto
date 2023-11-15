import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        String origin = inputView.calculatorString();
        VariableExpression expression = Calculator.calculate(origin.chars().mapToObj(e -> (char)e).collect(Collectors.toList()));
        resultView.calculateResult(expression.value());
    }
}
