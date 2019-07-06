package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLotto;
import lotto.domain.winning.LottoWinningResult;
import lotto.dto.LottoResultDto;

public class DefaultLottoService implements LottoService {

    private final LottoTicketGenerator lottoTicketGenerator;

    public DefaultLottoService(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public LottoTickets purchaseLottoTickets(long purchaseAmount) {
        return lottoTicketGenerator.generate(PurchaseAmount.of(purchaseAmount));
    }

    public LottoResultDto checkWinningAmount(LottoTickets lottoTickets, WinningLotto winningLotto, long purchaseAmount) {
        return LottoResultDto.of(LottoWinningResult.of(lottoTickets, winningLotto), PurchaseAmount.of(purchaseAmount));
    }
}
