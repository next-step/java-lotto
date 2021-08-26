package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.exception.NumbersIllegalArgumentException;

public class WinningTicket {

    private final Ticket firstPrizeTicket;
    private final LottoNumber bonusNumber;

    public WinningTicket(Ticket firstPrizeTicket, LottoNumber bonusNumber) {
        validateWinningTicketContains(firstPrizeTicket, bonusNumber);

        this.firstPrizeTicket = firstPrizeTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningTicketContains(Ticket firstPrizeTicket, LottoNumber bonusNumber) {
        if (firstPrizeTicket.contains(bonusNumber)) {
            throw new NumbersIllegalArgumentException("보너스 볼이 당첨 번호에 이미 포함되어 있습니다.");
        }
    }

    public Prize checkPrize(Ticket ticket) {
        int countOfMatch = countMatchingNumbers(ticket);
        boolean hasBonusNumber = ticket.contains(bonusNumber);

        return Prize.of(countOfMatch, hasBonusNumber);
    }

    private int countMatchingNumbers(Ticket ticket) {
        return (int) ticket.stream()
                .filter(firstPrizeTicket::contains)
                .count();
    }

}
