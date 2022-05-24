package lotto.domain;

import java.util.*;

public class Winners {
    public static final int COUNT_INITIAL = 0;

    private final Map<Rank, Integer> winners;

    private Winners() {
        this.winners = new LinkedHashMap<>();
        for (Rank winningsType : Rank.values()) {
            winners.put(winningsType, COUNT_INITIAL);
        }
    }

    private Winners(Rank rank) {
        this.winners = new LinkedHashMap<>();
        for (Rank winningsType : Rank.values()) {
            winners.put(winningsType, COUNT_INITIAL);
        }
        winners.put(rank, winners.getOrDefault(rank, 0) + 1);
    }

    public static Winners of() {
        return new Winners();
    }

    public static Winners of(Rank rank) {
        return new Winners(rank);
    }

    public Map<Rank, Integer> getWinners() {
        return new LinkedHashMap<>(winners);
    }

    public void findWinners(Lottos lottos, WinningNumbers winningNumbers) {
        Map<Rank, Integer> ranks = lottos.selectRankType(winningNumbers);
        winners.putAll(ranks);
    }

    public double revenue(int money) {
        double amount = 0;
        for (Rank winningsType : Rank.values()) {
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
