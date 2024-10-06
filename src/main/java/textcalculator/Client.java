package textcalculator;

public class Client {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        ResultView resultView = new ConsoleResultView();

        String formula = inputView.getFormulaFromUser();
        TextCalculator textCalCulator = new TextCalculator(formula);
        int result = textCalCulator.calculate();

        resultView.showResult(result);
    }
}
