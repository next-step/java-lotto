package lotto.service.dto;

import lotto.service.domain.WinningLottoNumber;
import lotto.service.model.LottoTickets;
import lotto.utils.Preconditions;

public class LottoResultCreateDTO {
    private final LottoTickets purchaseLottoTickets;
    private final WinningLottoNumber winningLottoNumber;

    public LottoResultCreateDTO(LottoTickets purchaseLottoTickets, WinningLottoNumber winningLottoNumber) {
        Preconditions.checkNotNull(purchaseLottoTickets, "purchaseLottoTickets는 필수값입니다.");
        Preconditions.checkNotNull(winningLottoNumber, "winningLottoNumber는 필수값입니다.");

        this.purchaseLottoTickets = purchaseLottoTickets;
        this.winningLottoNumber = winningLottoNumber;
    }

    public static LottoResultCreateDTO of(LottoTickets purchaseLottoTickets, WinningLottoNumber winningLottoNumber) {
        return new LottoResultCreateDTO(purchaseLottoTickets, winningLottoNumber);
    }

    public LottoTickets getPurchaseLottoTickets() {
        return purchaseLottoTickets;
    }

    public WinningLottoNumber getWinningLottoNumber() {
        return winningLottoNumber;
    }
}
