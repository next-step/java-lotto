package lotto.domain;

import java.util.List;
import java.util.Set;

public class WinnerTicket {
    private final Set<Integer> numbers;
    private final Integer bonusNumber;

    public WinnerTicket(Set<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Ticket ticketOnly() {
        return new Ticket(numbers);
    }

    public Boolean includeBonus(Ticket ticket) {
        return ticket.includeNumber(this.bonusNumber);
    }

    public int countWinner(List<Ticket> challengeTickets, Prize prize) {
        int count = 0;
        for(Ticket ticket : challengeTickets) {
            count = count + ( matchCount(ticket) && (checkBonusCondition(ticket,prize))  ? 1 : 0);
        }
        return count;
    }

    private boolean checkBonusCondition(Ticket ticket,Prize prize) {
        if (prize == Prize.SECOND) {
            return this.includeBonus(ticket);
        }
        return !this.includeBonus(ticket);
    }

    private boolean matchCount(Ticket ticket) {
        return Prize.THIRD.isMatch(ticket.countMatchNumbers(this.ticketOnly()));
    }
}
