package my.project.lotto.domain;

import java.text.DecimalFormat;
import java.util.List;

public class Ranks {
    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public void add(Rank rank) {
        this.ranks.add(rank);
    }

    public int getFifthRanks() {
        return (int) ranks.stream()
                .filter(rank -> rank.equals(Rank.FIFTH)).count();
    }

    public int getFourthRanks() {
        return (int) ranks.stream()
                .filter(rank -> rank.equals(Rank.FOURTH)).count();
    }

    public int getThirdRanks() {
        return (int) ranks.stream()
                .filter(rank -> rank.equals(Rank.THIRD)).count();
    }

    public int getFirstRanks() {
        return (int) ranks.stream()
                .filter(rank -> rank.equals(Rank.FIRST)).count();
    }

    public String getProfit() {
        DecimalFormat format = new DecimalFormat("#.##");
        return format.format((double) ((Rank.FIRST.getPrize() * getFirstRanks())
                                            + (Rank.THIRD.getPrize() * getThirdRanks())
                                            + (Rank.FOURTH.getPrize() * getFourthRanks())
                                            + (Rank.FIFTH.getPrize() * getFifthRanks()))
                                            / (ranks.size() * Money.PRICE));
    }
}
