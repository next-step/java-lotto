package lotto.service;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketType;

import java.util.List;

public class LottoManualService {

    public LottoTicket purchaseLottoTicket(List<String> manualLottoPurchaseNumberList) {
        return new LottoTicket(manualLottoPurchaseNumberList, LottoTicketType.MANUAL);
    }

}
