package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.exception.NumbersIllegalArgumentException;

public class BonusNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int bonumsNumber;

    public BonusNumber(int bonusNumber, Ticket winningTicket) {
        validateOutOfRange(bonusNumber);
        validateWinningTicketContains(bonusNumber, winningTicket);

        this.bonumsNumber = bonusNumber;
    }

    public static BonusNumber of(int bonusNumber, Ticket winningTicket) {
        return new BonusNumber(bonusNumber, winningTicket);
    }

    private void validateOutOfRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new NumbersIllegalArgumentException("지정 가능 숫자 범위 초과. 범위 : " + MIN_NUMBER + " ~ " + MAX_NUMBER);
        }
    }

    private void validateWinningTicketContains(int bonusNumber, Ticket winningTicket) {
        if (winningTicket.contains(bonusNumber)) {
            throw new NumbersIllegalArgumentException("당첨 번호에 이미 포함되어 있습니다.");
        }
    }
}
