package lotto.domain;

import java.util.EnumMap;
import java.util.Objects;

public class Bank {

    private final EnumMap<Rank, Integer> whetherOrNot;

    public Bank(EnumMap<Rank, Integer> whetherOrNot) {
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
        Bank bank = (Bank) o;
        return Objects.equals(whetherOrNot, bank.whetherOrNot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(whetherOrNot);
    }

    @Override
    public String toString() {
        return "Bank{" +
            "whetherOrNot=" + whetherOrNot +
            '}';
    }
}
