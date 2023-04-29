package lotto.domain;

import java.util.List;
import java.util.Set;

public class WinnerTicket {
    private final Ticket ticket;
    private final Integer bonusNumber;

    public WinnerTicket(Ticket ticket, Integer bonusNumber) {
        this.ticket = ticket;
        this.bonusNumber = bonusNumber;
    }

    public Ticket ticketOnly() {
        return this.ticket;
    }

    public Boolean includeBonus(Ticket ticket) {
        return ticket.includeNumber(this.bonusNumber);
    }

    public int countWinner(List<Ticket> challengeTickets, Prize prize) {
        int count = 0;
        for (Ticket ticket : challengeTickets) {
            count = count + (matchCount(ticket) && (checkBonusCondition(ticket, prize)) ? 1 : 0);
        }
        return count;
    }

    private boolean checkBonusCondition(Ticket ticket, Prize prize) {
        return (prize == Prize.SECOND) ? this.includeBonus(ticket) : !this.includeBonus(ticket);
    }

    private boolean matchCount(Ticket ticket) {
        return Prize.THIRD.isMatch(ticket.countMatchNumbers(this.ticketOnly()));
    }
}
