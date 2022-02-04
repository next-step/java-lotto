package lotto;


import lotto.domain.BonusNumber;
import lotto.domain.Budget;
import lotto.domain.CorrectNumbers;
import lotto.domain.Judge;
import lotto.domain.LottoRanks;
import lotto.domain.Lottos;
import lotto.domain.RankCounts;
import lotto.domain.Statistics;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.PrintView;

public class LottoApplication {

    public static void main(String[] args) {

        Budget budget = new Budget(InputView.inputBudget());
        Lottos lottos = Lottos.createAutoLottos(budget);
        PrintView.printNumberOfLotto(lottos.get().size());
        PrintView.printLottoNumber(lottos);

        CorrectNumbers correctNumbers = new CorrectNumbers(
            new WinningNumbers(InputView.inputWinningNumbers()),
            new BonusNumber(InputView.inputBonusNumber()));

        Judge judge = new Judge(correctNumbers);
        LottoRanks lottoRanks = judge.getRanks(lottos);

         Statistics statistics = new Statistics(lottoRanks);
         RankCounts rankCounts = statistics.getRankCounts();
    }
}
