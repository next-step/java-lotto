package lotto.controller.dto;

import lotto.service.domain.WinningLottoTicket;
import lotto.service.model.LottoTickets;
import lotto.service.value.LottoPrice;
import lotto.utils.Preconditions;

public class LottoResultParam {
    private final LottoTickets purchaseLottoTickets;
    private final WinningLottoTicket winningLottoTicket;

    public LottoResultParam(LottoTickets purchaseLottoTickets, WinningLottoTicket winningLottoTicket) {
        Preconditions.checkNotNull(purchaseLottoTickets, "purchaseLottoTickets는 필수값입니다.");
        Preconditions.checkNotNull(winningLottoTicket, "winningLottoTicket는 필수값입니다.");

        this.purchaseLottoTickets = purchaseLottoTickets;
        this.winningLottoTicket = winningLottoTicket;
    }

    public static LottoResultParam of(LottoTickets purchaseLottoTickets, WinningLottoTicket winningLottoTicket) {
        return new LottoResultParam(purchaseLottoTickets, winningLottoTicket);
    }

    public LottoTickets getPurchaseLottoTickets() {
        return purchaseLottoTickets;
    }

    public WinningLottoTicket getWinningLottoTicket() {
        return winningLottoTicket;
    }

    public LottoPrice getLottoPrice() {
        return purchaseLottoTickets.getLottoPrice();
    }
}
