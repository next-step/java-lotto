package lotto.domain.lotto;

import lotto.enums.Rank;

public class WinningLotto extends Lotto {
    private LottoNumber bonusNumber;

    public WinningLotto(Ticket ticket, LottoNumber bonusNumber) {
        ticket.sort();
        this.ticket = ticket;
        createBonusNumber(bonusNumber);
    }

    private void createBonusNumber(LottoNumber bonusNumber) {
        if (ticket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼 중복");
        }
        this.bonusNumber = bonusNumber;
    }

    public Rank match(BasicLotto lotto) {
        return Rank.valueOf(checkMatchNumbers(lotto), checkBonusNumber(lotto));
    }

    private int checkMatchNumbers(BasicLotto lotto) {
        return ticket.matchCount(lotto.ticket);
    }

    private boolean checkBonusNumber(BasicLotto lotto) {
        return lotto.ticket.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
