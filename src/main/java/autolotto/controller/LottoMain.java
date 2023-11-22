package autolotto.controller;

import autolotto.domain.*;
import autolotto.strategy.LottoNumberGeneratorImpl;
import autolotto.ui.InputView;
import autolotto.ui.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMain {
    public static void main(String[] args) {
        int ticketsCount = new Ticket(InputView.buyAmt()).toTicketCount();
        int manualLottoCount = 0;
        List<Lotto> manualLottos = Optional.ofNullable(InputView.manualLotto()).orElse(Collections.emptyList());
        LottoGame lottoGame = new LottoGame(new LottoNumberGeneratorImpl());
        if (!manualLottos.isEmpty()) {
            manualLottoCount = manualLottos.size();
        }
        List<Lotto> autoLottos = Optional.ofNullable(lottoGame.getLottoTickets(ticketsCount - manualLottoCount))
                .orElse(Collections.emptyList());
        List<Lotto> combinedLottos = Stream.concat(manualLottos.stream(), autoLottos.stream())
                .collect(Collectors.toList());
        ResultView.printLottoNumber(combinedLottos, manualLottoCount, ticketsCount);
        LottoStatistics lottoStatistics
                = new LottoStatistics(combinedLottos, new WinLotto(new Lotto(InputView.lastWeekWinNumber()), InputView.bonusNumber()));
        Map<Rank, Integer> rankIntegerMap = lottoStatistics.calcuratorRankCount();
        ResultView.printStatistics(rankIntegerMap, lottoStatistics.calcuratorProfit(rankIntegerMap, ticketsCount));
    }
}