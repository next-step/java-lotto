package lotto.domain;

import lotto.common.PositiveNumber;
import lotto.domain.ticket.*;
import lotto.domain.winning.LottoWinningResult;
import lotto.dto.LottoPurchaseRequestDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoWinningRequestDto;

public class DefaultLottoService implements LottoService {

    private final LottoTicketGenerator lottoTicketGenerator;

    public DefaultLottoService(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseRequestDto lottoPurchaseRequestDto) {
        PurchaseAmount purchaseAmount = PurchaseAmount.of(lottoPurchaseRequestDto.getPurchaseAmount().get());
        LottoTickets manualTickets = LottoTickets.ofManual(lottoPurchaseRequestDto.getManualTicketNumbers());
        return lottoTicketGenerator.generate(purchaseAmount);
    }

    public LottoResultDto checkWinningAmount(LottoWinningRequestDto lottoWinningRequestDto) {
        WinningLotto winningLotto = WinningLotto.of(LottoTicket.of(lottoWinningRequestDto.getWinningTicket().getCsvLong()),
                LottoNumber.of(lottoWinningRequestDto.getBonusNumber().get()));
        LottoTickets purchaseTickets = lottoWinningRequestDto.getPurchaseTickets();

        return LottoResultDto.of(LottoWinningResult.of(purchaseTickets, winningLotto), PositiveNumber.of(purchaseTickets.count()));
    }
}
