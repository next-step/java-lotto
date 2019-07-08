package lotto.dto;

import lotto.common.Csv;
import lotto.common.PositiveNumber;
import lotto.domain.ticket.LottoTickets;

public class LottoWinningRequestDto {

    private Csv winningTicket;
    private PositiveNumber bonusNumber;
    private LottoTickets purchaseTickets;

    private LottoWinningRequestDto(Csv winningTicket, PositiveNumber bonusNumber, LottoTickets purchaseTickets) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
        this.purchaseTickets = purchaseTickets;
    }

    public static LottoWinningRequestDto of (Csv winningTicket, PositiveNumber bonusNumber, LottoTickets purchaseTickets) {
        return new LottoWinningRequestDto(winningTicket, bonusNumber, purchaseTickets);
    }

    public Csv getWinningTicket() {
        return winningTicket;
    }

    public PositiveNumber getBonusNumber() {
        return bonusNumber;
    }

    public LottoTickets getPurchaseTickets() {
        return purchaseTickets;
    }
}
