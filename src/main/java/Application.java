import domain.Calculator;
import domain.Numbers;
import domain.Operators;
import view.InputView;
import view.OutputView;

public class Application {

  public static void main(String[] args) {
    String[] input = InputView.scanInput();
    Numbers numbers = InputView.number(input);
    Operators operators = InputView.operator(input);
    Calculator calculator = new Calculator(numbers, operators);
    int result = calculator.calculate();
    OutputView.printResult(result);
  }

}
