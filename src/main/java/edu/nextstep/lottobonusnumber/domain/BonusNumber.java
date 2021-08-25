package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.exception.NumbersIllegalArgumentException;

public class BonusNumber {

    private final LottoNumber bonusNumber;

    private BonusNumber(LottoNumber bonusNumber, Ticket winningTicket) {
        validateWinningTicketContains(bonusNumber, winningTicket);

        this.bonusNumber = bonusNumber;
    }

    private void validateWinningTicketContains(LottoNumber lottoNumber, Ticket winningTicket) {
        if (winningTicket.contains(lottoNumber)) {
            throw new NumbersIllegalArgumentException("당첨 번호에 이미 포함되어 있습니다.");
        }
    }

    public static BonusNumber of(LottoNumber bonusNumber, Ticket winningTicket) {
        return new BonusNumber(bonusNumber, winningTicket);
    }

    public static BonusNumber of(int bonusNumber, Ticket winningTicket) {
        return BonusNumber.of(LottoNumber.of(bonusNumber), winningTicket);
    }

    public boolean isEqualTo(LottoNumber number) {
        return (number.equals(bonusNumber));
    }
}
