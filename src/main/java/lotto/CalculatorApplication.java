package lotto;

import lotto.domain.Calculator;
import lotto.domain.NumberGroup;
import lotto.domain.OperatorGroup;
import lotto.utility.InputChecker;
import lotto.view.InputView;

import java.util.List;

public class CalculatorApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputChecker inputChecker = new InputChecker();

        String formula = inputView.askFormula();
        List<String> formulaList = inputChecker.formulaToStrList(formula);

        NumberGroup numberGroup = new NumberGroup(formulaList);
        OperatorGroup operatorGroup = new OperatorGroup(formulaList);

//        inputChecker.validFormula(formulaList);

//        Calculator calculator = new Calculator();

//        calculator.calculateFormula(formulaList);

//        System.out.println(calculator.showResult());
    }
}
