package lotto.domain;

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
}
