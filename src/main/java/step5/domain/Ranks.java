package step5.domain;

import java.util.List;

public class Ranks {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final long BASE_NUMBER = 0L;

    private List<Rank> ranks;

    private Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public static Ranks of(List<Rank> ranks) {
        return new Ranks(ranks);
    }

    public long findCountWithAmount(int winningMoney) {
        return ranks.stream().filter(rank -> rank.getWinningMoney() == winningMoney).count();
    }

    public double earningRate() {
        long sum = ranks.stream().map(rank -> rank.getWinningMoney() * findCountWithAmount(rank.getWinningMoney())).reduce(BASE_NUMBER, Long::sum);
        return sum / (double) (ranks.size() * ONE_LOTTO_PRICE);

    }

}
