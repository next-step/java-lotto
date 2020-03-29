package stringPlusCalculate;


import stringPlusCalculate.Controller.MainController;
import stringPlusCalculate.Domain.Calculator;
import stringPlusCalculate.View.InputView;

public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController(InputView.init(), Calculator.init());
        mainController.calculate();

    }
}
