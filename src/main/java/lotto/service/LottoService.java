package lotto.service;

import lotto.service.domain.LottoTicketGenerator;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.model.LottoTicket;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoNumber;
import lotto.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private static final Integer START_QUANTITY = 1;
    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoService(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseDTO lottoPurchaseDTO) {
        Preconditions.checkNotNull(lottoPurchaseDTO, "lottoPurchaseDTO의 값이 없습니다.");

        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = START_QUANTITY; i <= lottoPurchaseDTO.getPurchaseQuantity(); i++) {
            lottoTickets.add(lottoTicketGenerator.makeLottoTicket());
        }
        return LottoTickets.from(lottoTickets);
    }

    public LottoTicket getWinningLottoTicket(List<Integer> winningNumbers) {
        Preconditions.checkNotNull(winningNumbers, "winningNumbers의 값이 없습니다.");

        Collections.sort(winningNumbers);
        List<LottoNumber> numbers = winningNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
        return LottoTicket.from(numbers);
    }
}
