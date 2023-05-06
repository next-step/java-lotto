package lotto.domain;

import lotto.enums.Rank;

import java.util.List;
import java.util.Set;

public class Win {
    private List<Integer> winningNumbers;
    private int bonusBall;

    public Win(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public int countSameNumber(Set<Integer> ticketNumbers) {
        return (int) winningNumbers.stream()
                .filter(ticketNumbers::contains)
                .count();
    }

    public Rank getRank(Set<Integer> ticketNumbers) {
        return Rank.of(countSameNumber(ticketNumbers), isBonusWin(ticketNumbers));
    }

    public boolean isBonusWin(Set<Integer> ticketNumbers) {
        return ticketNumbers.contains(bonusBall);
    }
}
