package lotto.domain;


import java.util.List;

public class LottoStatics {
    // 3개 이상부터 통계
    public static final int MIN_STATIC_RANK = 3;
    public static final int[] RANK_PRIZE = new int[] {0,0,0,5_000,50_000,1_500_000,2_000_000_000};

    private List<Rank> ranks;

    public LottoStatics(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public Profit getProfit() {
        double total = getTotalPrize();
        int totalCost = Lotto.PRICE *  ranks.size();

        return new Profit(total , totalCost);
    }

    private double getTotalPrize() {
        double total = 0;
        for ( Rank rank : ranks) {
            total += Rank.prize(rank);
        }
        return total;
    }

    public int getRankCount(int targetRank) {
        int count = 0;
        for (Rank rank : ranks) {
            if( rank == Rank.of(targetRank)) {
                count++;
            }
        }
        return count;
    }

}
