package lotto;

import lotto.domain.LottoGame;
import lotto.domain.price.Price;
import lotto.domain.dto.LottoTicketDto;
import lotto.domain.prize.LottoPrizeResult;
import lotto.domain.seller.LottoSeller;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        Price price = Price.of(InputView.inputPurchasePrice());

        LottoSeller seller = LottoSeller.of();
        LottoTickets tickets = seller.buyTicket(price);

        ResultView.printPurchaseInfo(LottoTicketDto.from(tickets));

        String winningNumbers = InputView.inputWinningNumbers();
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of(winningNumbers);

        LottoPrizeResult result = LottoGame.of(price, tickets).play(winningLottoTicket);

        ResultView.printResult(result);
    }
}
