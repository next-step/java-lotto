package lotto.domain;

import java.util.EnumMap;
import java.util.Objects;

public class Bank {

    private final EnumMap<Rank, Integer> rankIntegerEnumMap;

    public Bank(EnumMap<Rank, Integer> rankIntegerEnumMap) {
        this.rankIntegerEnumMap = rankIntegerEnumMap;
    }

    public double yield(int purchaseMoney) {
        return Rank.yield(rankIntegerEnumMap, purchaseMoney);
    }

    public EnumMap<Rank, Integer> getRankIntegerEnumMap() {
        return new EnumMap<>(rankIntegerEnumMap);
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
        return Objects.equals(rankIntegerEnumMap, bank.rankIntegerEnumMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankIntegerEnumMap);
    }
}
