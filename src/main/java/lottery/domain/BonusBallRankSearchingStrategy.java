package lottery.domain;

import java.util.Arrays;

public class BonusBallRankSearchingStrategy implements RankSearchingStrategy {

    @Override
    public LotteryRank searchLotteryRank(int matchNumberCounts, int bonusBallCount) {
        return Arrays.stream(LotteryRank.values())
                .filter(lotteryRank -> lotteryRank.getMatchNumberCounts() <= matchNumberCounts)
                .filter(lotteryRank -> lotteryRank.getBonusBallCount() <= bonusBallCount)
                .findFirst()
                .orElse(LotteryRank.MISS);
    }
}
