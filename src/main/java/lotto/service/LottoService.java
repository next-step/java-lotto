package lotto.service;

import lotto.service.domain.LottoResultMaker;
import lotto.service.domain.LottoTicket;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.domain.factory.LottoTicketFactory;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.dto.LottoResultCreateDTO;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.model.LottoNumbers;
import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final Integer START_LOTTO_QUANTITY = 1;
    private final LottoResultMaker lottoResultMaker;
    private final LottoTicketFactory lottoTicketFactory;

    public LottoService(LottoResultMaker lottoResultMaker, LottoTicketFactory lottoTicketFactory) {
        this.lottoResultMaker = lottoResultMaker;
        this.lottoTicketFactory = lottoTicketFactory;
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseDTO lottoPurchaseDTO) {
        Preconditions.checkNotNull(lottoPurchaseDTO, "lottoPurchaseDTO의 값이 없습니다.");

        List<LottoTicket> manualLottoTickets = createManualLottoTickets(lottoPurchaseDTO);
        List<LottoTicket> lottoTickets = createAutoLottoTickets(lottoPurchaseDTO);
        return LottoTickets.of(lottoTickets, manualLottoTickets);
    }

    public WinningLottoTicket getWinningLottoTicket(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        Preconditions.checkNotNull(winningLottoNumbers, "winningLottoNumbers의 값이 없습니다.");
        Preconditions.checkNotNull(bonusNumber, "bonusNumber의 값이 없습니다.");

        List<LottoNumber> winningNumbers = winningLottoNumbers.stream()
                .sorted()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return WinningLottoTicket.of(winningNumbers, bonusNumber);
    }

    public LottoResult checkLottoResult(LottoResultCreateDTO lottoResultCreateDTO) {
        Preconditions.checkNotNull(lottoResultCreateDTO, "lottoResultCreateDTO의 값이 없습니다.");

        return lottoResultMaker.checkLottoResult(lottoResultCreateDTO.getPurchaseLottoTickets(),
                                                 lottoResultCreateDTO.getWinningLottoTicket());
    }

    private List<LottoTicket> createManualLottoTickets(LottoPurchaseDTO lottoPurchaseDTO) {
        return lottoPurchaseDTO.getLottoNumbersList().stream()
                .map(LottoNumbers::getLottoNumbers)
                .map(lottoTicketFactory::createLottoTicketByManual)
                .collect(Collectors.toList());
    }

    private List<LottoTicket> createAutoLottoTickets(LottoPurchaseDTO lottoPurchaseDTO) {
        return IntStream.rangeClosed(START_LOTTO_QUANTITY, lottoPurchaseDTO.getAutoLottoQuantity())
                .mapToObj(v -> lottoTicketFactory.createLottoTicketByAuto())
                .collect(Collectors.toList());
    }
}
