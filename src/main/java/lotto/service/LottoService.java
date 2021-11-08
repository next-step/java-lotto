package lotto.service;

import lotto.service.domain.LottoTicketGenerator;
import lotto.service.dto.LottoPurchaseDTO;
import lotto.service.model.LottoTicket;
import lotto.service.model.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final Integer START_QUANTITY = 1;
    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoService(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public LottoTickets purchaseLottoTickets(LottoPurchaseDTO lottoPurchaseDTO) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = START_QUANTITY; i <= lottoPurchaseDTO.getPurchaseQuantity(); i++) {
            lottoTickets.add(lottoTicketGenerator.makeLottoTicket());
        }
        return LottoTickets.from(lottoTickets);
    }
}
