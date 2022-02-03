package lotto;


import lotto.domain.Budget;
import lotto.view.InputView;

public class LottoApplication {

    public static void main(String[] args) {

        Budget budget = new Budget(InputView.inputBudget());
    }
}
