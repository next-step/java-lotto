package lotto;


import lotto.domain.Budget;
import lotto.domain.CorrectNumbers;
import lotto.domain.Judge;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRanks;
import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.view.InputView;
import lotto.view.PrintView;

public class LottoApplication {

    public static void main(String[] args) {

        final Budget budget = new Budget(InputView.inputBudget());

        final Lottos manualLottos = Lottos.createManualLottos(InputView.inputManualLottoNumbers(), budget);
        final Lottos autoLottos = Lottos.createAutoLottos(budget);
        final Lottos allLottos = manualLottos.merge(autoLottos);

        PrintView.printNumberOfLotto(manualLottos.size(), autoLottos.size());
        PrintView.printLottoNumber(allLottos);

        final CorrectNumbers correctNumbers = new CorrectNumbers(
                InputView.inputWinningNumbers(),
                InputView.inputBonusNumber());

        final Judge judge = new Judge(correctNumbers);
        final LottoRanks lottoRanks = judge.getRanks(allLottos);

        final Statistics statistics = new Statistics(lottoRanks);
        PrintView.printResult(statistics.getResult());
    }
}
