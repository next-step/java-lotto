package stringPlusCalculate.Controller;


import stringPlusCalculate.Domain.Formula;
import stringPlusCalculate.View.InputView;
import stringPlusCalculate.View.ResultView;

public class MainController {

    InputView inputView;
    ResultView resultView;
    Formula formula;

    public MainController(InputView inputView, Formula model) {
        this.inputView = inputView;
        this.formula = model;
        this.resultView = ResultView.init();
    }

    public void calculate() {
    }

}
