package lotto;


import java.util.List;
import lotto.domain.budget.Budget;
import lotto.domain.correctnumber.CorrectNumbers;
import lotto.domain.judge.Judge;
import lotto.domain.lotto.Lottos;
import lotto.domain.lottorank.LottoRanks;
import lotto.domain.statistics.Statistics;
import lotto.view.InputView;
import lotto.view.PrintView;

public class LottoApplication {

    public static void main(String[] args) {

        final Budget budget = new Budget(InputView.inputBudget());
        List<String> manualLottoNumbers = InputView.inputManualLottoNumbers();
        final Budget autoLottoBudget = budget.deductionPerLotto(manualLottoNumbers.size());

        final Lottos manualLottos = Lottos.createManualLottos(manualLottoNumbers);
        final Lottos autoLottos = Lottos.createAutoLottos(autoLottoBudget);
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
