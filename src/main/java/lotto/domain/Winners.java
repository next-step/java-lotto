package lotto.domain;

import java.util.*;

public class Winners {
    public static final int COUNT_UNIT = 1;
    public static final int COUNT_INITIAL = 0;

    private Map<WinningsType, Integer> winners = new LinkedHashMap<>();
    private WinningNumbers winningNumbers;

    public Winners(List<Integer> winningNumbers, int bonusNumber) {
        for (WinningsType winningsType : WinningsType.values()) {
            winners.put(winningsType, COUNT_INITIAL);
        }
        this.winningNumbers = new WinningNumbers(winningNumbers, bonusNumber);
    }

    public Map<WinningsType, Integer> getWinners() {
        return winners;
    }

    public void findWinners(Lotto lotto) {
        int count = winningNumbers.numberOfSame(lotto);
        addWinner(lotto, count);
    }

    public void addWinner(Lotto lotto, int count) {
        WinningsType temporary = WinningsType.selectWinningsType(count, winningNumbers.isSameBonus(lotto)).get();
        winners.put(temporary, winners.get(temporary) + COUNT_UNIT);
    }

    public double revenue(int money) {
        double amount = 0;
        for (WinningsType winningsType : WinningsType.values()) {
            amount += winningsType.getWinnings() * winners.get(winningsType);
        }
        return amount / money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }

    @Override
    public String toString() {
        return "Winners{" +
                "winners=" + winners +
                '}';
    }
}
