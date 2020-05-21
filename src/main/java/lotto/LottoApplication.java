package lotto;

import lotto.domain.LottoGame;
import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.seller.LottoSeller;
import lotto.domain.strategy.RandomGenerationStrategy;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.WinningLottoTicket;
import lotto.domain.view.InputView;
import lotto.domain.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int payment = InputView.inputPurchaseAmount();

        LottoSeller seller = LottoSeller.of(new RandomGenerationStrategy(LottoTicket.LOTTO_NUMBER_SIZE));
        List<LottoTicket> tickets = seller.buyTicket(payment);

        ResultView.printPurchaseInfo(tickets);

        String winningNumbers = InputView.inputWinningNumbers();
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(winningNumbers);

        LottoPrizeResult result = LottoGame.of(tickets).play(winningLottoTicket);

        ResultView.printStatisticsResult(result);
        ResultView.printProfitRate(result.calculateProfitRate(payment));
    }
}
