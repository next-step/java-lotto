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
            winners.put(WinningsType.selectWinningsType(i), COUNT_INITIAL);
        }
    }

    public void findWinners(Lotto lotto) {
        int count = winningNumbers.numberOfSame(lotto);
        if (count >= WINNING_MINIMUM) {
            addWinner(count);
        }
    }

    public void addWinner(int count) {
        WinningsType temporary = WinningsType.selectWinningsType(count);
        winners.put(temporary, winners.get(temporary) + COUNT_UNIT);
    }

    public double revenue(int money) {
        double amount = 0;
        for (int i = 3; i <= 6; i++) {
            amount += WinningsType.selectWinnings(i) * winners.get(WinningsType.selectWinningsType(i));
        }
        return amount / money;
    }

    public String isBenefit(double revenue) {
        if (revenue > 1) {
            return "이득";
        }
        if (revenue < 1) {
            return "손해";
        }
        return "본전";
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
        return winners.toString();
    }


}
