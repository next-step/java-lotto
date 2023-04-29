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

    public UserTicket ticketOnly() {
        return new UserTicket(numbers);
    }

    public Boolean includeBonus(UserTicket userTicket) {
        return userTicket.includeNumber(this.bonusNumber);
    }

    public int countWinner(List<UserTicket> challengeUserTickets, Prize prize) {
        int count = 0;
        for (UserTicket userTicket : challengeUserTickets) {
            count = count + (matchCount(userTicket) && (checkBonusCondition(userTicket, prize)) ? 1 : 0);
        }
        return count;
    }

    private boolean checkBonusCondition(UserTicket userTicket, Prize prize) {
        return (prize == Prize.SECOND) ? this.includeBonus(userTicket) : !this.includeBonus(userTicket);
    }

    private boolean matchCount(UserTicket userTicket) {
        return Prize.THIRD.isMatch(userTicket.countMatchNumbers(this.ticketOnly()));
    }
}
