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

//        WinningNumbers winningNumberVo = new WinningNumbers(InputView.inputWinningNumbers(),InputView.inputBonusNumber())

        // Judge judge = new Judge(winningNumberVo);
        // LottoRanks lottoRanks = judge.getRank(lottos);

        // Statistics statistics = new Statistics(lottoRanks);
        // NumberOfRanks numberOfRanks = staticstics.getNumberOfRank();

        // printView.printNumberOfRank(numberOfRanks);
        // printView.printProfitRate(staticstics.getProfitRate());
    }
}
