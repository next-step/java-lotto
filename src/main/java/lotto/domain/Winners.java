package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Winners {
    public static final int WINNING_MINIMUM = 3;
    public static final int COUNT_UNIT = 1;
    public static final int COUNT_INITIAL = 0;

    private final Map<WinningsType, Integer> winners = new LinkedHashMap<>();
    private final Lotto winningNumbers;

    public Winners(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
        for (int i = 3; i <= 6; i++) {
            winners.put(WinningsType.selectWinningsType(i).get(), COUNT_INITIAL);
        }
    }

    public Map<WinningsType, Integer> getWinners() {
        return winners;
    }

    public void findWinners(Lotto lotto) {
        int count = winningNumbers.numberOfSame(lotto);
        if (count >= WINNING_MINIMUM) {
            addWinner(count);
        }
    }

    public void addWinner(int count) {
        WinningsType temporary = WinningsType.selectWinningsType(count).get();
        winners.put(temporary, winners.get(temporary) + COUNT_UNIT);
    }

    public double revenue(int money) {
        double amount = 0;
        for (int i = 3; i <= 6; i++) {
            amount += WinningsType.selectWinningsType(i).get().getWinnings() * winners.get(WinningsType.selectWinningsType(i).get());
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
                ", winningNumbers=" + winningNumbers +
                '}';
    }
}
