package lotto.domain;

import java.util.*;

public class Winners {
    public static final int COUNT_UNIT = 1;
    public static final int COUNT_INITIAL = 0;

    private final Map<WinningsType, Integer> winners;

    public Winners() {
        this.winners = new LinkedHashMap<>();
        for (WinningsType winningsType : WinningsType.values()) {
            winners.put(winningsType, COUNT_INITIAL);
        }
    }

    public Map<WinningsType, Integer> getWinners() {
        return new LinkedHashMap<>(winners);
    }

    public void findWinners(Lotto lotto, WinningNumbers winningNumbers) {
        int count = winningNumbers.numberOfSame(lotto);
        WinningsType temporary = WinningsType.selectWinningsType(count, winningNumbers.isSameBonus(lotto));
        addWinner(temporary);
    }

    public void addWinner(WinningsType winningsType) {
        winners.put(winningsType, winners.get(winningsType) + COUNT_UNIT);
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
