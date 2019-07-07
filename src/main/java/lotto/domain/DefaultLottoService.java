package lotto.domain;

import lotto.common.PositiveNumber;
import lotto.domain.ticket.*;
import lotto.domain.winning.LottoWinningResult;
import lotto.dto.LottoPurchaseRequestDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoWinningRequestDto;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultLottoService implements LottoService {

    private final LottoTicketGenerator lottoTicketGenerator;

    public DefaultLottoService(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseRequestDto lottoPurchaseRequestDto) {
        PurchaseAmount purchaseAmount = PurchaseAmount.ofManual(lottoPurchaseRequestDto.getPurchaseAmount(), lottoPurchaseRequestDto.getManualTicketCount());

        LottoTickets manualTickets = LottoTickets.ofManual(lottoPurchaseRequestDto.getManualTicketNumbers());
        LottoTickets autoTickets = lottoTicketGenerator.generate(purchaseAmount.getNumberOfAutoTickets());

        return LottoTickets.of(Stream.of(manualTickets, autoTickets)
                .flatMap(lottoTicket -> lottoTicket.findAll().stream())
                .collect(Collectors.toList()));
    }

    public LottoResultDto checkWinningAmount(LottoWinningRequestDto lottoWinningRequestDto) {
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(lottoWinningRequestDto.getWinningTicket().getCsvLong()),
                LottoNumber.of(lottoWinningRequestDto.getBonusNumber().get()));
        LottoTickets purchaseTickets = lottoWinningRequestDto.getPurchaseTickets();

        return LottoResultDto.of(LottoWinningResult.of(purchaseTickets, winningLotto), purchaseTickets.count());
    }
}
