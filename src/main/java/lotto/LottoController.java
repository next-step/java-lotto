package lotto;

import lotto.domain.*;
import lotto.domain.purchaseStrategy.AutoPurchaseStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public final class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoMachine lottoMachine = new LottoMachine();

        int amount = inputView.inputAmount();
        Lottos lottos = lottoMachine.buyLotto(amount, new AutoPurchaseStrategy());
        int totalCount = lottos.count();

        resultView.printLottoCount(totalCount);
        resultView.printLottos(lottos);

        Lotto winningLotto = new Lotto(inputView.inputWinningNumbers());
        Map<Rank, MatchingCount> winnings = lottoMachine.makeStatisticsWinnings(lottos, winningLotto);
        double earningsRate = lottoMachine.calculateEarningsRate(winnings, totalCount);

        resultView.printStatistics(winnings);
        resultView.printEarningsRate(earningsRate);
        inputView.endInput();
    }

}
