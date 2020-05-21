package lotto.ui;

import lotto.domain.rank.Rank;
import lotto.domain.rank.Ranks;

import java.util.Arrays;

import static lotto.domain.rank.Rank.*;

public class PrizeOutputView {
    private Ranks ranks;

    public PrizeOutputView(Ranks ranks) {
        this.ranks = ranks;
    }

    protected String getIndividualStatistics(Rank rank) {
        return rank.getMatchNumber() +
                "개 일치 (" +
                rank.getPrice() +
                "원)- " +
                ranks.getCount(rank) +
                "개";
    }

    public String getTotalStatistics() {
        return Arrays.stream(Rank.values())
                .filter(rank -> FOURTH.equals(rank) || THIRD.equals(rank) || SECOND.equals(rank) || FIRST.equals(rank))
                .map(this::getIndividualStatistics)
                .reduce("", (a, b) -> a + b + "\n");
    }
}
