package lotto;

import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoPurchase;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.creator.KoreanRandomLottoCreator;
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
        LottoPurchase lottoPurchase = new LottoPurchase(wallet.getMoney(), InputView.getHandLottoQuantity());

        LottoMachine lottoMachine = new LottoMachine(lottoPurchase.getAutomaticLottoQuantity(), new KoreanRandomLottoCreator());
        Lottos lottos = new Lottos(InputView.getHandLottos(lottoPurchase.getHandLottoQuantity()), lottoMachine.getLottos());
        ResultView.printLottoPurchase(lottoPurchase.getHandLottoQuantity(), lottoPurchase.getAutomaticLottoQuantity());
        ResultView.printLottos(lottos.getLottos());

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        LottoJudgement judgement = new LottoJudgement(lottos.getLottos(), winningNumbers);
        NumberOfResults numberOfResults = new NumberOfResults(judgement.getLottoResults());

        WinningStatistics winningStatistics = new WinningStatistics(numberOfResults.getNumberOfResults(), wallet.getMoney());
        ResultView.printResult(numberOfResults.getNumberOfResults(), winningStatistics.getProfitRate());
    }
}
