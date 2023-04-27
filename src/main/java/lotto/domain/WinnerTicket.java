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
        if(prize == Prize.THIRD)  {
            return true;
        }
        return this.includeBonus(ticket) && prize.needBonusNumberMatch();
    }

    private boolean matchCount(Ticket ticket) {
        return Prize.THIRD.isMatch(ticket.overlapNumberCount(this.ticketOnly()));
    }

    public int countSecondWinner(List<Ticket> challengeTickets) {
        int count = 0;
        for(Ticket ticket : challengeTickets) {
            count = count + ((Prize.THIRD.isMatch(ticket.overlapNumberCount(this.ticketOnly())) && this.includeBonus(ticket) ) ? 1 : 0);
        }
        return count;
    }

    public int countThirdWinner(List<Ticket> challengeTickets) {
        int count = 0;
        for(Ticket ticket : challengeTickets) {
            count = count + ((Prize.THIRD.isMatch(ticket.overlapNumberCount(this.ticketOnly())) && !this.includeBonus(ticket) ) ? 1 : 0);
        }
        return count;
    }
}
