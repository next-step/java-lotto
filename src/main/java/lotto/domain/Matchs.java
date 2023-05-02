package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Matchs {

    Map<Match, Long> matchs;

    public Matchs(Map<Match, Long> matchs) {
        this.matchs = matchs;
    }

    public Money calculateWinningAmount() {
        return matchs.entrySet().stream()
                .map(entry -> entry.getKey().getMoney().multiply(entry.getValue()))
                .reduce(new Money(0L), Money::add);
    }

    @Override
    public String toString() {
        return Arrays.stream(Match.values())
                .map(match -> match.getMessage(matchs.getOrDefault(match, 0L)))
                .collect(Collectors.joining("\n"));
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
}
