import domain.Calculator;
import view.InputView;
import view.ResultView;

public class Main {

  public static void main(String[] args) {

    String question = InputView.expression();
    Calculator calculator = new Calculator();
    int result = calculator.getResult(question);
    ResultView.printResult(result);
  }

}
