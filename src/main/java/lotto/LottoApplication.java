package lotto;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.RandomLottoCreator;
import lotto.domain.result.LottoJudgement;
import lotto.domain.result.NumberOfResults;
import lotto.domain.result.WinningStatistics;
import lotto.domain.user.Wallet;
import lotto.domain.winning.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        Wallet wallet = new Wallet(InputView.getMoney());

        LottoMachine lottoMachine = new LottoMachine(wallet.getMoney(), new RandomLottoCreator());

        List<Lotto> lottos = lottoMachine.getLottos();
        ResultView.printUserLottos(lottos);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        LottoJudgement judgement = new LottoJudgement(lottos, winningNumbers);
        NumberOfResults numberOfResults = new NumberOfResults(judgement.getLottoResults());

        WinningStatistics winningStatistics = new WinningStatistics(numberOfResults.getNumberOfResults(), wallet.getMoney());
        ResultView.printResult(numberOfResults.getNumberOfResults(), winningStatistics.getProfitRate());
    }
}
