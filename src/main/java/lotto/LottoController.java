package lotto;

import lotto.domain.*;
import lotto.domain.purchaseStrategy.AutoPurchaseStrategy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.EnumMap;
import java.util.Scanner;

public final class LottoController {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InputView inputView = new InputView(scanner);
            ResultView resultView = new ResultView();
            LottoMachine lottoMachine = new LottoMachine();

            Lottos lottos = lottoMachine.buyLotto(inputView.inputAmount(), new AutoPurchaseStrategy());
            int totalCount = lottos.count();

            resultView.printLottoCount(totalCount);
            resultView.printLottos(lottos);

            Lotto winningLotto = Lotto.valueOf(inputView.inputWinningNumbers());
            WinningsStatistics winningsStatistics = new WinningsStatistics(winningLotto, new LottoNumber(5));
            EnumMap<Rank, MatchingCount> winnings = winningsStatistics.makeStatisticsWinningsByRank(lottos);
            double earningsRate = winningsStatistics.calculateEarningsRate(winnings, totalCount);

            resultView.printStatistics(winnings);
            resultView.printEarningsRate(earningsRate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
