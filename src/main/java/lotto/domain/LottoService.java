package lotto.domain;

import lotto.domain.ticket.LottoTickets;
import lotto.dto.LottoResultDto;

import java.util.List;

public interface LottoService {
    LottoTickets purchaseLottoTickets(long purchaseAmount);
    LottoResultDto checkWinnintAmount(LottoTickets lottoTickets, List<Long> winningTicket, long purchaseAmount);
}
