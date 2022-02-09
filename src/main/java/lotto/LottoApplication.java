package lotto;


import lotto.domain.Budget;
import lotto.domain.CorrectNumbers;
import lotto.domain.Judge;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRanks;
import lotto.domain.Lottos;
import lotto.domain.Statistics;
import lotto.domain.WinningNumbers;
import lotto.domain.dto.ResultDto;
import lotto.view.InputView;
import lotto.view.PrintView;

public class LottoApplication {

    public static void main(String[] args) {

        final Budget budget = new Budget(InputView.inputBudget());
        final Lottos lottos = Lottos.createAutoLottos(budget);
        PrintView.printNumberOfLotto(lottos.get().size());
        PrintView.printLottoNumber(lottos);

        final CorrectNumbers correctNumbers = new CorrectNumbers(
                new WinningNumbers(InputView.inputWinningNumbers()),
                new LottoNumber(InputView.inputBonusNumber()));

        final Judge judge = new Judge(correctNumbers);
        final LottoRanks lottoRanks = judge.getRanks(lottos);

        final Statistics statistics = new Statistics(lottoRanks);
        final ResultDto resultDto = new ResultDto(statistics.getRankCounts(), statistics.getProfitRate());

        PrintView.printResult(resultDto);
    }
}
