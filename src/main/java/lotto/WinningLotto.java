package lotto;

public class WinningLotto {
    private final LottoNumbers winningTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(LottoNumbers winningTicket, LottoNumber bonusNumber) {
        if (winningTicket.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼이 당첨 번호와 겹치면 안됩니다.");
        }
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult match(LottoNumbers ticket) {
        return LottoResult.of(getMatchCount(ticket), hasBonusNumber(ticket));
    }

    private boolean hasBonusNumber(LottoNumbers ticket) {
        return ticket.hasNumber(bonusNumber);
    }

    private int getMatchCount(LottoNumbers ticket) {
        return winningTicket.getMatchCount(ticket);
    }
}
