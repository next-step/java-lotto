package lotto.step2;

import lotto.step2.domain.*;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();
        ResultView.printLottoCount(lottoPrice);
        Lotto lotto = new Lotto();
        Lotto lottoTickets = lotto.buyLotto(lottoPrice);
        ResultView.printLottoTicket(lottoTickets);
        List<Integer> lastWinningNumber = InputView.inputLastWinningNumber();
        WinningNumber winningNumber = new WinningNumber(lastWinningNumber);
        ResultView.printWinningStatisticsMessage();
        Map<WinningRank, Integer> winningRank = LottoResult.checkLottoTicket(winningNumber, lottoTickets);
        ResultView.printWinningRank(winningRank);
        double statistics = LottoResult.calculateStatistics(lottoPrice);
        ResultView.printStatistics(statistics);
    }
}
