package step1.application;

import step1.domain.ArithmeticExpression;
import step1.domain.CalculatingMachine;

public class ApplicationMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(inputView.input());

        CalculatingMachine calculatingMachine = new CalculatingMachine(arithmeticExpression.numbers(),
            arithmeticExpression.operators());
        OutputView outputView = new OutputView(calculatingMachine.calculation());
        outputView.result();
    }
}
