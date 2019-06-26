package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.winning.LottoWinningChecker;
import lotto.dto.LottoResultDto;

import java.util.List;

public class DefaultLottoService implements LottoService {

    private final LottoTicketGenerator lottoTicketGenerator;

    public DefaultLottoService(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public LottoTickets purchaseLottoTickets(long purchaseAmount) {
        return lottoTicketGenerator.generate(PurchaseAmount.of(purchaseAmount));
    }

    public LottoResultDto checkWinnintAmount(LottoTickets lottoTickets, List<Long> winningTicket, long purchaseAmount) {
        return LottoResultDto.of(LottoWinningChecker.of(lottoTickets, LottoTicket.of(winningTicket)).getWinnigResult(), PurchaseAmount.of(purchaseAmount));
    }
}
