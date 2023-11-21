package autolotto.controller;

import autolotto.domain.*;
import autolotto.strategy.LottoNumberGeneratorImpl;
import autolotto.ui.InputView;
import autolotto.ui.ResultView;

import java.util.List;
import java.util.Map;

public class AutoLottoMain {
    public static void main(String[] args) {
        int ticketsCount = new Ticket(InputView.buyAmt()).toTicketCount();
        System.out.println(ticketsCount + "개를 구매했습니다.");
        LottoGame lottoGame = new LottoGame(ticketsCount, new LottoNumberGeneratorImpl());
        List<Lotto> lottoTickets = lottoGame.getLottoTickets();
        ResultView.printLottoNumber(lottoTickets);

        LottoStatistics lottoStatistics
                = new LottoStatistics(lottoTickets, new WinLotto(new Lotto(InputView.lastWeekWinNumber()), InputView.bonusNumber()));

        Map<Rank, Integer> rankIntegerMap = lottoStatistics.calcuratorRankCount();
        ResultView.printStatistics(rankIntegerMap, lottoStatistics.calcuratorProfit(rankIntegerMap, ticketsCount));
    }
}