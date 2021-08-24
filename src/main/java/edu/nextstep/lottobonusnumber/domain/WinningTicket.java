package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.domain.ticketmaker.CustomNumbersMaker;
import edu.nextstep.lottobonusnumber.domain.ticketmaker.NumbersMaker;
import edu.nextstep.lottobonusnumber.exception.NumbersIllegalArgumentException;

public class WinningTicket {
    private final Ticket winningTicket;
    private final int bonusNumber;

    private WinningTicket(Ticket winningTicket, int bonusNumber) {
        validateAlreadyHas(winningTicket, bonusNumber);
        validateOutOfRange(bonusNumber);

        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validateOutOfRange(int bonusNumber) {
        if (bonusNumber < Ticket.MIN_NUMBER || bonusNumber > Ticket.MAX_NUMBER) {
            throw new NumbersIllegalArgumentException("지정 가능 숫자 범위 초과. 범위 : " + Ticket.MIN_NUMBER + " ~ " + Ticket.MAX_NUMBER);
        }
    }

    private void validateAlreadyHas(Ticket ticket, int bonusNumber) {
        if (ticket.contains(bonusNumber)) {
            throw new NumbersIllegalArgumentException("해당 보너스 볼은 당첨 번호에 이미 포함되어 있습니다.");
        }
    }

    public static WinningTicket of(String winningNumbersString, int bonusNumber) {
        NumbersMaker numbersMaker = new CustomNumbersMaker(winningNumbersString);
        Ticket winningTicket = Ticket.madeBy(numbersMaker);
        return new WinningTicket(winningTicket, bonusNumber);
    }

    public Ticket getWinningTicket() {
        return winningTicket;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }




}
