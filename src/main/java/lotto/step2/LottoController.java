package lotto.step2;

import lotto.step2.domain.*;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;


public class LottoController {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();
        LottoShop lottoShop = new LottoShop(lottoPrice);
        ResultView.printLottoCount(lottoPrice);
        Lotto lottoTickets = lottoShop.sellLotto();
        ResultView.printLottoTicket(lottoTickets);
        LottoTicket winningNumber = LottoTicket.generateWinningNumber(InputView.inputLastWinningNumber());
        ResultView.printWinningStatisticsMessage();
        LottoBuyer lottoResult = new LottoBuyer(winningNumber);
        lottoTickets.matchLotto(lottoResult);
        ResultView.printWinningRank(lottoResult.getLottoResult());
        ResultView.printStatistics(lottoResult.calculateStatistics(lottoPrice));
    }
}
