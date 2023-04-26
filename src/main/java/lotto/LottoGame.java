package lotto;

import lotto.utility.InputChecker;
import lotto.view.InputView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputChecker inputChecker = new InputChecker();

        String formula = inputView.askFormula();
        List<String> formulaList = inputChecker.formulaToStrList(formula);

        inputChecker.validFormula(formulaList);
    }
}
