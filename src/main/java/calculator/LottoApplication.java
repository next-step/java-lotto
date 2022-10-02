package calculator;

import calculator.domain.Formula;
import calculator.domain.SingleFormula;
import calculator.view.InputView;

public class LottoApplication {
    public static void main(String[] args) {

        // sample
        // 2 + 3 * 4 / 2 = 10
        // 1 - 2 * 3 + 4 - 5 + 6 * 7 - 8 = 6

        InputView inputView = new InputView();

        Formula formula = new Formula(inputView.getFormulaString());
        SingleFormula singleFormula = formula.getFirstSingleFormula();
        int result = singleFormula.doOperate();

        System.out.println(result);
    }

}
