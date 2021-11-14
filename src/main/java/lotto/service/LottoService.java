package lotto.service;

import lotto.service.domain.LottoResultMaker;
import lotto.service.domain.LottoTicket;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.domain.factory.LottoTicketFactory;
import lotto.service.model.LottoNumbers;
import lotto.service.model.LottoResult;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;
import lotto.validator.LottoValidator;

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

    public LottoTickets purchaseLottoTickets(Integer autoLottoQuantity, List<LottoNumbers> lottoNumbersList) {
        Preconditions.checkNotNull(autoLottoQuantity, "autoLottoQuantity의 값이 없습니다.");
        Preconditions.checkNotNull(lottoNumbersList, "lottoNumbersList의 값이 없습니다.");

        List<LottoTicket> manualLottoTickets = createManualLottoTickets(lottoNumbersList);
        List<LottoTicket> lottoTickets = createAutoLottoTickets(autoLottoQuantity);
        return LottoTickets.of(lottoTickets, manualLottoTickets);
    }

    public WinningLottoTicket getWinningLottoTicket(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        Preconditions.checkNotNull(winningLottoNumbers, "winningLottoNumbers의 값이 없습니다.");
        Preconditions.checkNotNull(bonusNumber, "bonusNumber의 값이 없습니다.");
        LottoValidator.checkBonusNumber(winningLottoNumbers, bonusNumber);

        List<LottoNumber> winningNumbers = winningLottoNumbers.stream()
                .sorted()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return WinningLottoTicket.of(winningNumbers, bonusNumber);
    }

    public LottoResult checkLottoResult(LottoTickets purchaseLottoTickets, WinningLottoTicket winningLottoTicket) {
        Preconditions.checkNotNull(purchaseLottoTickets, "purchaseLottoTickets의 값이 없습니다.");
        Preconditions.checkNotNull(winningLottoTicket, "winningLottoTicket의 값이 없습니다.");

        return lottoResultMaker.checkLottoResult(purchaseLottoTickets, winningLottoTicket);
    }

    private List<LottoTicket> createManualLottoTickets(List<LottoNumbers> lottoNumbersList) {
        return lottoNumbersList.stream()
                .map(LottoNumbers::getLottoNumbers)
                .map(lottoTicketFactory::createLottoTicketByManual)
                .collect(Collectors.toList());
    }

    private List<LottoTicket> createAutoLottoTickets(Integer autoLottoQuantity) {
        return IntStream.rangeClosed(START_LOTTO_QUANTITY, autoLottoQuantity)
                .mapToObj(v -> lottoTicketFactory.createLottoTicketByAuto())
                .collect(Collectors.toList());
    }
}
