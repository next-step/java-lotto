package lotto.step2;

import lotto.step2.domain.*;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

import java.util.Map;

public class LottoController {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();
        LottoShop lottoShop = new LottoShop(lottoPrice);
        ResultView.printLottoCount(lottoPrice);
        Lotto lottoTickets = lottoShop.sellLotto();
        ResultView.printLottoTicket(lottoTickets);
        LottoTicket winningNumber = LottoTicket.generateWinningNumber(InputView.inputLastWinningNumber());
        ResultView.printWinningStatisticsMessage();
        LottoResult lottoResult = new LottoResult();
        Map<WinningRank, Integer> winningRank = lottoResult.checkLottoTicket(winningNumber, lottoTickets);
        ResultView.printWinningRank(winningRank);
        ResultView.printStatistics(lottoResult.calculateStatistics(lottoPrice));
    }
}
