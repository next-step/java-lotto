package lotto;


import lotto.domain.Budget;
import lotto.domain.Lottos;
import lotto.view.InputView;

public class LottoApplication {

    public static void main(String[] args) {

        Budget budget = new Budget(InputView.inputBudget());
        Lottos lottos = Lottos.createAutoLottos(budget);
    }
}
