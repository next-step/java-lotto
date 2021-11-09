package lotto.service.dto;

import lotto.service.domain.LottoTicket;
import lotto.service.model.LottoTickets;
import lotto.utils.Preconditions;

public class LottoResultCreateDTO {
    private final LottoTickets purchaseLottoTickets;
    private final LottoTicket winningLottoTicket;

    public LottoResultCreateDTO(LottoTickets purchaseLottoTickets, LottoTicket winningLottoTicket) {
        Preconditions.checkNotNull(purchaseLottoTickets, "purchaseLottoTickets는 필수값입니다.");
        Preconditions.checkNotNull(winningLottoTicket, "winningLottoTicket는 필수값입니다.");

        this.purchaseLottoTickets = purchaseLottoTickets;
        this.winningLottoTicket = winningLottoTicket;
    }

    public static LottoResultCreateDTO of(LottoTickets purchaseLottoTickets, LottoTicket winningLottoTicket) {
        return new LottoResultCreateDTO(purchaseLottoTickets, winningLottoTicket);
    }

    public LottoTickets getPurchaseLottoTickets() {
        return purchaseLottoTickets;
    }

    public LottoTicket getWinningLottoTicket() {
        return winningLottoTicket;
    }
}
