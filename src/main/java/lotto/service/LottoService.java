package lotto.service;

import lotto.service.domain.LottoResultMaker;
import lotto.service.domain.LottoTicket;
import lotto.service.domain.LottoTicketMaker;
import lotto.service.domain.WinningLottoNumber;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.dto.LottoResultCreateDTO;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final Integer START_LOTTO_QUANTITY = 1;
    private final LottoTicketMaker lottoTicketMaker;
    private final LottoResultMaker lottoResultMaker;

    public LottoService(LottoTicketMaker lottoTicketMaker, LottoResultMaker lottoResultMaker) {
        this.lottoTicketMaker = lottoTicketMaker;
        this.lottoResultMaker = lottoResultMaker;
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseDTO lottoPurchaseDTO) {
        Preconditions.checkNotNull(lottoPurchaseDTO, "lottoPurchaseDTO의 값이 없습니다.");

        List<LottoTicket> lottoTickets = IntStream.rangeClosed(START_LOTTO_QUANTITY,
                                                               lottoPurchaseDTO.getLottoQuantity())
                .mapToObj(v -> lottoTicketMaker.createLottoTicket())
                .collect(Collectors.toList());
        return LottoTickets.from(lottoTickets);
    }

    public WinningLottoNumber getWinningLottoNumber(List<Integer> winningLottoNumbers) {
        Preconditions.checkNotNull(winningLottoNumbers, "winningLottoNumbers의 값이 없습니다.");

        List<LottoNumber> numbers = winningLottoNumbers.stream()
                .sorted()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return WinningLottoNumber.of(numbers, LottoNumber.from(-1));
    }

    public LottoResult checkLottoResult(LottoResultCreateDTO lottoResultCreateDTO) {
        Preconditions.checkNotNull(lottoResultCreateDTO, "lottoResultCreateDTO의 값이 없습니다.");

        return lottoResultMaker.checkLottoResult(lottoResultCreateDTO.getPurchaseLottoTickets(),
                                                 lottoResultCreateDTO.getWinningLottoNumber());
    }
}
