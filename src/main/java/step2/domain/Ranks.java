package step2.domain;

import step2.domain.enums.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ranks {
    private final static int PRIZE_NUMBER_COUNT = 3;
    private final List<Rank> ranks;

    public Ranks(Lotteries lotteries, Lottery winningNumbers, Number bonusNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lottery lottery : lotteries.getLotteries()) {
            addRank(ranks, lottery, winningNumbers, bonusNumber);
        }

        this.ranks = ranks;
    }

    private void addRank(List<Rank> ranks, Lottery lottery, Lottery winningNumbers, Number bonusNumber) {
        int count = lottery.getCorrectCount(winningNumbers);

        if (count >= PRIZE_NUMBER_COUNT) {
            ranks.add(Rank.of(count, lottery.isCorrectBonusNumber(bonusNumber)));
        }
    }

    public int calculateProfitAmount() {
        int money = 0;

        for (Rank rank : ranks) {
            money += (rank != null) ? rank.getPrizeMoney() : 0;
        }

        return money;
    }

    public long getCountOfRank(Rank rank) {
        return ranks.stream()
                .filter(r -> rank.equals(r))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ranks ranks1 = (Ranks) o;
        return Objects.equals(ranks, ranks1.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranks);
    }
}
