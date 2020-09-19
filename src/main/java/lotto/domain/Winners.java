package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Winners {
    private Map<Rank, Count> winners = new HashMap<>();

    public Winners(){
        init();
    }

    private void init(){
        for(Rank rank : Rank.values()){
            winners.put(rank, Count.ZERO);
        }
    }

    public void addRank(Rank rank){
        winners.put(rank, winners.get(rank).increase());
    }

    public Count getWinnersCount(Rank rank){
        return winners.get(rank);
    }

    public BigDecimal calcWinnerPrize() {
        BigDecimal winningPrize = BigDecimal.ZERO;

        for(Rank rank : Rank.values()){
            BigDecimal winningMoeny = rank.getWinningMoney();
            BigDecimal count = getWinnersCount(rank).toBigDecimal();

            winningPrize = winningPrize.add(winningMoeny.multiply(count));
        }

        return winningPrize;
    }

    public int getSize(){
        return winners.size();
    }

    public BigDecimal rateOfPrize(){
        return calcWinnerPrize().divide(calcUsedMoney(), 2, BigDecimal.ROUND_CEILING);
    }

    private BigDecimal calcUsedMoney() {
        return BigDecimal.valueOf(winners.size()).multiply(Lotto.PRICE);
    }
}
