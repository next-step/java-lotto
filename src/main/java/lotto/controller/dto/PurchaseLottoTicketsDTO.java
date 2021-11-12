package lotto.controller.dto;

import lotto.service.domain.LottoTicket;
import lotto.service.model.LottoTickets;

import java.util.List;

public class PurchaseLottoTicketsDTO {
    private final Integer manualLottoCount;
    private final Integer autoLottoCount;
    private final LottoTickets lottoTickets;

    private PurchaseLottoTicketsDTO(Integer manualLottoCount, Integer autoLottoCount, LottoTickets lottoTickets) {
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = autoLottoCount;
        this.lottoTickets = lottoTickets;
    }

    public static PurchaseLottoTicketsDTO of(Integer manualLottoCount, Integer autoLottoCount,
                                             LottoTickets lottoTickets) {
        return new PurchaseLottoTicketsDTO(manualLottoCount, autoLottoCount, lottoTickets);
    }

    public Integer getManualLottoCount() {
        return manualLottoCount;
    }

    public Integer getAutoLottoCount() {
        return autoLottoCount;
    }

    public List<LottoTicket> getLottoTicketList() {
        return lottoTickets.getLottoTickets();
    }
}
