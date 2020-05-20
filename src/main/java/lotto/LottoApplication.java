package lotto;

import lotto.domain.seller.LottoSeller;
import lotto.domain.strategy.RandomGenerationStrategy;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.view.InputView;
import lotto.domain.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int amount = InputView.inputPurchaseAmount();

        LottoSeller seller = LottoSeller.of(new RandomGenerationStrategy(LottoTicket.LOTTO_NUMBER_SIZE));
        List<LottoTicket> tickets = seller.buyTicket(amount);

        ResultView.printPurchasedTicketCount(tickets.size());
        ResultView.printTickets(tickets);

        String winningNumbers = InputView.inputWinningNumbers();
    }
}
