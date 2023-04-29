package lotto.domain;

import java.util.List;

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
            count = count + (isWinner(ticket, prize) ? 1 : 0);
        }
        return count;
    }

    private boolean isWinner(Ticket challengerTicket, Prize prize) {
        return matchCount(challengerTicket, prize) && checkBonusCondition(challengerTicket, prize);
    }

    private boolean checkBonusCondition(Ticket ticket, Prize prize) {
        if (prize == Prize.SECOND) {
            return this.includeBonus(ticket);
        }
        if (prize == Prize.THIRD) {
            return !this.includeBonus(ticket);
        }
        return true;
    }

    private boolean matchCount(Ticket ticket, Prize prize) {
        return prize.isMatch(this.ticket.countMatchNumbers(ticket));
    }
}
