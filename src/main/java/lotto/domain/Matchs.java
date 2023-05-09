package lotto.domain;

import java.util.*;
public class Matchs {

    private final Map<Match, Long> matchs;

    public Matchs(Map<Match, Long> matchs) {
        this.matchs = matchs;
    }

    public Money calculateWinningAmount() {
        return matchs.entrySet().stream()
                .map(entry -> entry.getKey().getMoney().multiply(entry.getValue()))
                .reduce(new Money(0L), Money::add);
    }

    public Map<Match, Long> getMatchs() {
        return Collections.unmodifiableMap(matchs);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matchs matchs1 = (Matchs) o;
        return Objects.equals(matchs, matchs1.matchs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchs);
    }

    public double calculateRateOfEarning(Money buyAmount) {
        return calculateWinningAmount().divide(buyAmount);
    }
}
