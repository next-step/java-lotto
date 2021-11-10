package lotto.service.dto;

import lotto.service.domain.WinningLottoTicket;
import lotto.service.model.LottoTickets;
import lotto.utils.Preconditions;

public class LottoResultCreateDTO {
    private final LottoTickets purchaseLottoTickets;
    private final WinningLottoTicket winningLottoTicket;

    public LottoResultCreateDTO(LottoTickets purchaseLottoTickets, WinningLottoTicket winningLottoTicket) {
        Preconditions.checkNotNull(purchaseLottoTickets, "purchaseLottoTickets는 필수값입니다.");
        Preconditions.checkNotNull(winningLottoTicket, "winningLottoTicket는 필수값입니다.");

        this.purchaseLottoTickets = purchaseLottoTickets;
        this.winningLottoTicket = winningLottoTicket;
    }

    public static LottoResultCreateDTO of(LottoTickets purchaseLottoTickets, WinningLottoTicket winningLottoTicket) {
        return new LottoResultCreateDTO(purchaseLottoTickets, winningLottoTicket);
    }

    public LottoTickets getPurchaseLottoTickets() {
        return purchaseLottoTickets;
    }

    public WinningLottoTicket getWinningLottoTicket() {
        return winningLottoTicket;
    }
}
