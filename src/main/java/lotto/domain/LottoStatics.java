package lotto.domain;


import java.util.List;

public class LottoStatics {

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
