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
        LottoTicket winningNumber = new LottoTicket(InputView.inputLastWinningNumber());
        ResultView.printWinningStatisticsMessage();


        LottoResult lottoResult = new LottoResult(winningNumber);
        lottoTickets.matchLottoTicket(lottoResult);
        ResultView.printWinningRank(lottoResult.getLottoResult());
        ResultView.printStatistics(lottoResult.calculateStatistics(lottoPrice));

        LottoResult lottoResult1 = lottoTickets.matchLottoTicket2(winningNumber);
    }
}
