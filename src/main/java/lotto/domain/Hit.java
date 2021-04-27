package lotto.domain;

import java.util.Objects;

public class Hit {

    private final int winningCount;
    private final boolean bonus;

    public Hit(int winningCount, boolean bonus) {
        this.winningCount = winningCount;
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hit hit = (Hit) o;
        return winningCount == hit.winningCount &&
                bonus == hit.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningCount, bonus);
    }
}
