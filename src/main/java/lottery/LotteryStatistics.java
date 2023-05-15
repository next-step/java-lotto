package lottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryStatistics {

    private final Map<LotteryPlace, Integer> lotteryCntForPlace;
    private final Integer investment;
    private final Integer revenue;

    public LotteryStatistics(List<Lottery> lotteries, DrawResult drawResult) {
        lotteryCntForPlace = new HashMap<>();
        setUpLotteryCountForPlace(lotteries, drawResult);
        investment = getTotalInvestment(lotteries);
        revenue = getTotalRevenue();
    }

    private void setUpLotteryCountForPlace(List<Lottery> lotteries, DrawResult drawResult) {
        for (var lottery : lotteries) {
            var matchCnt = lottery.getRow().getMatchCount(drawResult.winningRow);
            var bonusHit = lottery.getRow().isBonusHit(drawResult.bonus);
            var place = LotteryPlace.fromMatchCnt(matchCnt, bonusHit);
            incrementLotteryCntForPlace(place);
        }
    }

    private void incrementLotteryCntForPlace(LotteryPlace place) {
        lotteryCntForPlace.put(place, lotteryCntForPlace.getOrDefault(place, 0) + 1);
    }

    private Integer getTotalRevenue() {
        int revenue = 0;
        for (var place : lotteryCntForPlace.keySet()) {
            revenue += place.getReward() * getLotteryCntForPlace(place);
        }
        return revenue;
    }

    private Integer getTotalInvestment(List<Lottery> lotteries) {
        return Lottery.PRICE * lotteries.size();
    }

    public Integer getLotteryCntForPlace(LotteryPlace place) {
        return lotteryCntForPlace.getOrDefault(place, 0);
    }

    public Float getRor() {
        return revenue / (float) investment;
    }

    public PnLType getPnLType() {
        return PnLType.fromRevenueAndInvestment(revenue, investment);
    }
}
