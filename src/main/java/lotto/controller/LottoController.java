package lotto.controller;

import lotto.application.AllAutomaticLottoTicketStrategy;
import lotto.application.LottoTicketGenerator;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.domain.Price;
import lotto.domain.WinningNumbers;

public class LottoController {

    private final LottoTicketGenerator ticketGenerator;

    public LottoController(LottoTicketGenerator ticketGenerator) {
        this.ticketGenerator = ticketGenerator;
    }

    public LottoTickets createLottoTickets(String purchaseAmount) {
        Price price = Price.of(purchaseAmount);

        return ticketGenerator.generateTickets(price, new AllAutomaticLottoTicketStrategy());
    }

    public LottoResult createLottoResult(String inputWinningNumbers, LottoTickets lottoTickets) {
        WinningNumbers winningNumbers = WinningNumbers.of(inputWinningNumbers);

        return LottoResult.createResult(lottoTickets, winningNumbers);
    }
}
