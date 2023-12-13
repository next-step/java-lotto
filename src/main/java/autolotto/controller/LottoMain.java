package autolotto.controller;

import autolotto.domain.Lotto;
import autolotto.domain.LottoGame;
import autolotto.domain.LottoNo;
import autolotto.domain.LottoStatistics;
import autolotto.domain.Rank;
import autolotto.domain.Ticket;
import autolotto.domain.WinLotto;
import autolotto.strategy.LottoNumberGeneratorImpl;
import autolotto.ui.InputView;
import autolotto.ui.ResultView;
import java.util.List;
import java.util.Map;

public class LottoMain {

    public static void main(String[] args) {
        int ticketsCount = new Ticket(InputView.buyAmt()).toTicketCount();
        int manualLottoCount = InputView.manualLottoCount(ticketsCount);

        LottoGame lottoGame = new LottoGame(ticketsCount, InputView.getManualNumbers(manualLottoCount),
                new LottoNumberGeneratorImpl());
        List<Lotto> combinedLottos = lottoGame.getLottos();

        ResultView.printLottoNumber(combinedLottos, manualLottoCount, ticketsCount);
        LottoStatistics lottoStatistics
                = new LottoStatistics(combinedLottos,
                new WinLotto(new Lotto(InputView.lastWeekWinNumber()), new LottoNo(InputView.bonusNumber())));
        Map<Rank, Integer> rankIntegerMap = lottoStatistics.calcuratorRankCount();
        ResultView.printStatistics(rankIntegerMap, lottoStatistics.calcuratorProfit(rankIntegerMap, ticketsCount));
    }

}