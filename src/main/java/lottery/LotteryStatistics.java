package lottery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryStatistics {
    private static final Map<Integer, Integer> rewardForMatchCnt = Map.of(
            0, 0,
            1, 0,
            2, 0,
            3, 5000,
            4, 50000,
            5, 150000,
            6, 2000000000
    );

    private final Map<Integer, Integer> lotteryCntForMatchCnt;
    private final Float ror;
    private final PnLType pnLType;

    public LotteryStatistics(List<Lottery> lotteries, LotteryRow winningRow, Integer lotteryPrice) {
        var revenue = 0;
        lotteryCntForMatchCnt = new HashMap<>();
        for (var lottery : lotteries) {
            var matchCnt = LotteryRow.fromGiven(lottery.getNumbers()).getMatchCount(winningRow);
            lotteryCntForMatchCnt.put(matchCnt, lotteryCntForMatchCnt.getOrDefault(matchCnt, 0) + 1);
            revenue += rewardForMatchCnt.get(matchCnt);
        }
        var investment = lotteryPrice * lotteries.size();
        ror = revenue / (float) investment;
        pnLType = PnLType.fromRevenueAndInvestment(revenue, investment);
    }

    public static Integer getRewardForMatchCnt(Integer matchCnt) {
        return rewardForMatchCnt.getOrDefault(matchCnt, 0);
    }

    public Integer getLotteryCntForMatchCnt(Integer matchCnt) {
        return lotteryCntForMatchCnt.getOrDefault(matchCnt, 0);
    }

    public Float getRor() {
        return ror;
    }

    public PnLType getPnLType() {
        return pnLType;
    }
}
