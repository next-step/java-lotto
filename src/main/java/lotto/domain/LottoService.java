package lotto.domain;

import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningLotto;
import lotto.dto.LottoResultDto;

public interface LottoService {
    LottoTickets purchaseLottoTickets(long purchaseAmount);
    LottoResultDto checkWinningAmount(LottoTickets lottoTickets, WinningLotto winningLotto, long purchaseAmount);
}
