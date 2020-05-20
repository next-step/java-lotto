package lotto;

import lotto.domain.number.LottoTicket;
import lotto.domain.seller.LottoSeller;
import lotto.domain.strategy.RandomGenerationStrategy;
import lotto.domain.view.InputView;
import lotto.domain.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int amount = InputView.inputPurchaseAmount();

        LottoSeller seller = LottoSeller.of(new RandomGenerationStrategy(6));
        List<LottoTicket> tickets = seller.buyTicket(amount);

        ResultView.printPurchasedTicketCount(tickets.size());

        String winningNumbers = InputView.inputWinningNumbers();
    }
}
