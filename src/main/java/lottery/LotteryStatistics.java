package lottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryStatistics {

    private final Map<LotteryPlace, Natural> lotteryCntForPlace;
    private final Natural investment;
    private final Natural revenue;

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
        var oldValue = lotteryCntForPlace.getOrDefault(place, new Natural(0)).value();
        lotteryCntForPlace.put(place, new Natural(oldValue + 1));
    }

    private Natural getTotalRevenue() {
        int revenue = 0;
        for (var place : lotteryCntForPlace.keySet()) {
            revenue += place.getReward().value() * getLotteryCntForPlace(place).value();
        }
        return new Natural(revenue);
    }

    private Natural getTotalInvestment(List<Lottery> lotteries) {
        return new Natural(Lottery.PRICE * lotteries.size());
    }

    public Natural getLotteryCntForPlace(LotteryPlace place) {
        return lotteryCntForPlace.getOrDefault(place, new Natural(0));
    }

    public Float getRor() {
        return revenue.value() / (float) investment.value();
    }

    public PnLType getPnLType() {
        return PnLType.fromRevenueAndInvestment(revenue, investment);
    }
}
