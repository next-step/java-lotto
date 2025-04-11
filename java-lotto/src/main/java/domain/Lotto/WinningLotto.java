package domain.Lotto;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final LottoNo bonusNumber;

    public WinningLotto(LottoTicket winningTicket, LottoNo bonusNumber) {
        if (winningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }


    public LottoTicket getWinningTicket() {
        return winningTicket;
    }

    public LottoNo getBonusNumber() {
        return bonusNumber;
    }

    public int matchCountWith(LottoTicket ticket) {
        return ticket.countMatchingNumbersWith(this.winningTicket);
    }

    public boolean hasBonus(LottoTicket ticket) {
        return ticket.contains(this.bonusNumber);
    }

}