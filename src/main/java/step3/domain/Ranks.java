package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Ranks {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final int BASE_NUMBER = 0;

    private List<Rank> ranks;

    public Ranks() {
        ranks = new ArrayList<>();
    }

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public void addRank(Rank rank) {
        ranks.add(rank);
    }

    public long findCountWithAmount(int winningMoney) {
        return ranks.stream().filter(rank -> rank.getWinningMoney() == winningMoney).count();
    }

    public double earningRate() {
        long sum = (long) ranks.stream().map(rank -> rank.getWinningMoney() * rank.getCountOfMatch()).reduce(BASE_NUMBER, Integer::sum);

        return sum / (double) (ranks.size() * ONE_LOTTO_PRICE);

    }

}
