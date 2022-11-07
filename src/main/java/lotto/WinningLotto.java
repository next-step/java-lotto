package lotto;

import java.util.List;

public class WinningLotto {
    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        this(LottoTicket.of(winningNumbers), bonusNumber);
    }

    public WinningLotto(LottoTicket winningTicket, LottoNumber bonusNumber) {
        if (winningTicket.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼이 당첨 번호와 겹치면 안됩니다.");
        }
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult match(LottoTicket ticket) {
        return LottoResult.of(getMatchCount(ticket), hasBonusNumber(ticket));
    }

    private boolean hasBonusNumber(LottoTicket ticket) {
        return ticket.hasNumber(bonusNumber);
    }

    private int getMatchCount(LottoTicket ticket) {
        return winningTicket.getMatchCount(ticket);
    }
}
