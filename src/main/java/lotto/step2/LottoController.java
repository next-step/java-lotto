package lotto.step2;

import lotto.step2.domain.*;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

import java.util.Set;

public class LottoController {
    public static void main(String[] args) {
        int money = InputView.inputLottoPrice();
        Lotto lottoTickets = new Lotto(money);
        ResultView.printLottoCount(money);
        ResultView.printLottoTicket(lottoTickets);
        Set<LottoNumber> lastWinningNumber = InputView.inputLastWinningNumber();
        LottoTicket winningNumber = new LottoTicket(lastWinningNumber);
        ResultView.printWinningStatisticsMessage();
        LottoResult lottoResult = lottoTickets.matchLottoTicket(winningNumber);
        ResultView.printWinningRank(lottoResult.getLottoResult());
        ResultView.printStatistics(lottoResult.calculateStatistics(money));

    }
}
