package lotto;

import lotto.domain.LottoGame;
import lotto.domain.number.LottoNumbers;
import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.seller.LottoSeller;
import lotto.domain.ticket.WinningLottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int price = InputView.inputPurchasePrice();

        LottoSeller seller = LottoSeller.of();
        List<LottoNumbers> tickets = seller.buyTicket(price);

        ResultView.printPurchaseInfo(tickets);

        String winningNumbers = InputView.inputWinningNumbers();
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(winningNumbers);

        LottoPrizeResult result = LottoGame.of(tickets).play(winningLottoTicket);

        ResultView.printStatisticsResult(result);
        ResultView.printProfitRate(result.calculateProfitRate(price));
    }
}
