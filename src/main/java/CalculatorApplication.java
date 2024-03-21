import domain.Calculator;
import domain.Numbers;
import domain.Symbols;
import view.InputView;
import view.ResultView;


public class CalculatorApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] line = inputView.split(inputView.getInput());
        Calculator calculator = new Calculator(Numbers.create(line), Symbols.create(line));
        int result = calculator.run();
        ResultView.printResult(result);
    }
}
