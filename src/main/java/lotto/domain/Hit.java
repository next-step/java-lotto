package lotto.domain;

import java.util.Objects;

public class Hit {

    private final int winningCount;
    private final boolean bonus;

    public Hit(int winningCount, boolean bonus) {
        this.winningCount = winningCount;
        this.bonus = bonus;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hit hit = (Hit) o;
        return getWinningCount() == hit.getWinningCount() &&
                isBonus() == hit.isBonus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWinningCount(), isBonus());
    }
}
