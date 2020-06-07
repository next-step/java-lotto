package lottery.domain;

public interface RankSearchingStrategy {

    public LotteryRank searchLotteryRank(int matchNumberCounts, int bonusBallCount);
}
