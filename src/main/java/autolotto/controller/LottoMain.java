package autolotto.controller;

import autolotto.domain.*;
import autolotto.strategy.LottoNumberGeneratorImpl;
import autolotto.ui.InputView;
import autolotto.ui.ResultView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMain {
    public static void main(String[] args) {
        int ticketsCount = new Ticket(InputView.buyAmt()).toTicketCount();

        int manualLottoCount = InputView.manualLottoCount(ticketsCount);
        List<List<Integer>> manualNumbers = IntStream.range(0, manualLottoCount)
                .mapToObj(i -> InputView.inputNumbers())
                .collect(Collectors.toList());

        LottoGame lottoGame = new LottoGame(new LottoNumberGeneratorImpl());
        List<Lotto> manualLottos = lottoGame.getLottoTickets(manualNumbers);
        List<Lotto> autoLottos = lottoGame.getLottoTickets(ticketsCount - manualLottoCount);
        List<Lotto> combinedLottos = Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());

        ResultView.printLottoNumber(combinedLottos, manualLottoCount, ticketsCount);
        LottoStatistics lottoStatistics
                = new LottoStatistics(combinedLottos, new WinLotto(new Lotto(InputView.lastWeekWinNumber()), new LottoNo(InputView.bonusNumber())));
        Map<Rank, Integer> rankIntegerMap = lottoStatistics.calcuratorRankCount();
        ResultView.printStatistics(rankIntegerMap, lottoStatistics.calcuratorProfit(rankIntegerMap, ticketsCount));
    }
}