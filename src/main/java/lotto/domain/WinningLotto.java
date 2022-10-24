package lotto.domain;

import java.util.EnumMap;
import java.util.Objects;

public class WinningLotto {

    private final EnumMap<Rank, Integer> whetherOrNot;

    public WinningLotto(EnumMap<Rank, Integer> whetherOrNot) {
        this.whetherOrNot = whetherOrNot;
    }

    public double yield(int purchaseMoney) {
        return Rank.yield(whetherOrNot, purchaseMoney);
    }

    public EnumMap<Rank, Integer> winningConfirmation() {
        return new EnumMap<>(whetherOrNot);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLotto winningLotto = (WinningLotto) o;
        return Objects.equals(whetherOrNot, winningLotto.whetherOrNot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whetherOrNot);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
            "whetherOrNot=" + whetherOrNot +
            '}';
    }
}
