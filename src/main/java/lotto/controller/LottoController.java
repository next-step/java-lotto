package lotto.controller;

import lotto.domain.AllAutomaticLottoTicketStrategy;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.value.*;
import lotto.utils.InputUtils;

import java.util.Map;

public class LottoController {

    private final LottoTicketGenerator ticketGenerator;

    public LottoController(LottoTicketGenerator ticketGenerator) {
        this.ticketGenerator = ticketGenerator;
    }

    public LottoTickets createLottoTickets(String purchaseAmount) {
        Price price = InputUtils.createPrice(purchaseAmount);

        return ticketGenerator.generateTickets(price, new AllAutomaticLottoTicketStrategy());
    }

    public LottoResult createLottoResult(String inputWinningNumbers, LottoTickets lottoTickets) {
        WinningNumbers winningNumbers = InputUtils.createWinningNumbers(inputWinningNumbers);

        Map<Rank, Integer> winningRank = lottoTickets.creatWinningRank(winningNumbers);

        return LottoResult.of(winningRank, lottoTickets.size());
    }
}
