package stringPlusCalculate.Controller;


import stringPlusCalculate.Domain.Calculator;
import stringPlusCalculate.Domain.Formula;
import stringPlusCalculate.Domain.Operator;
import stringPlusCalculate.View.InputView;
import stringPlusCalculate.View.ResultView;

public class MainController {

    InputView inputView;
    ResultView resultView;
    Calculator calculator;

    public MainController(InputView inputView, Calculator model) {
        this.inputView = inputView;
        this.calculator = model;
        this.resultView = ResultView.init();
    }

    public void calculate() {
        Double result = calculator.calculate(inputView.userInteractionString(), Operator.PLUS);
        resultView.resultPrint(result);
    }

}
