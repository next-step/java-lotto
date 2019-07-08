package lotto.domain;

import lotto.domain.ticket.LottoTickets;
import lotto.dto.LottoPurchaseRequestDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoWinningRequestDto;

public interface LottoService {
    LottoTickets purchaseLottoTickets(LottoPurchaseRequestDto lottoPurchaseRequestDto);
    LottoResultDto checkWinningAmount(LottoWinningRequestDto lottoWinningRequestDto);
}
