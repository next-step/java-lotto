public class MainApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    Formula formula = new Formula(inputView.readFormula());
    ResultView resultView = new ResultView();
    Calculator calculator = new Calculator();

    int result = calculator.calculate(formula.getTokens());

    resultView.showResult(result);
  }
}
