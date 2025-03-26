public class MainApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    Formula formula = new Formula(inputView.readFormula());
    ResultView resultView = new ResultView();

    int result = formula.calculate();
    resultView.showResult(result);
  }
}
