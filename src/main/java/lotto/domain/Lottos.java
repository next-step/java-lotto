package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int findRankCount(final Lotto win, final Rank rank) {
        return (int) lottos.stream()
                .filter(lotto -> Rank.findRank(lotto.countSameNumber(win)) == rank)
                .count();
    }

    public int totalEarnings(final Lotto win) {
        return lottos.stream()
                .map(lotto -> lotto.findLottoRank(win).getRewards())
                .reduce(0, Integer::sum);
    }

    public double calculateProfit(final Lotto win, int money) {
        return (double) totalEarnings(win) / (double) money;
    }

    public List<Lotto> getValue() {
        return lottos;
    }

}
