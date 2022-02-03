package lotto;


import lotto.domain.Budget;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.PrintView;

public class LottoApplication {

    public static void main(String[] args) {

        Budget budget = new Budget(InputView.inputBudget());
        Lottos lottos = Lottos.createAutoLottos(budget);
        PrintView.printNumberOfLotto(lottos.get().size());
        PrintView.printLottoNumber(lottos);
    }
}
