package step2;

public class WinLotteryResult {
    private final RewardCountAndPrizeMoney hitThreeTimes;
    private final RewardCountAndPrizeMoney hitFourTimes;
    private final RewardCountAndPrizeMoney hitFiveTimes;
    private final RewardCountAndPrizeMoney hitSixTimes;
    private final Money totalPrizeMoney;

    public WinLotteryResult(final RewardCountAndPrizeMoney hitThreeTimes,
                            final RewardCountAndPrizeMoney hitFourTimes,
                            final RewardCountAndPrizeMoney hitFiveTimes,
                            final RewardCountAndPrizeMoney hitSixTimes,
                            final Money totalPrizeMoney) {
        this.hitThreeTimes = hitThreeTimes;
        this.hitFourTimes = hitFourTimes;
        this.hitFiveTimes = hitFiveTimes;
        this.hitSixTimes = hitSixTimes;
        this.totalPrizeMoney = totalPrizeMoney;
    }

    public RewardCountAndPrizeMoney getHitThreeTimes() {
        return hitThreeTimes;
    }

    public RewardCountAndPrizeMoney getHitFourTimes() {
        return hitFourTimes;
    }

    public RewardCountAndPrizeMoney getHitFiveTimes() {
        return hitFiveTimes;
    }

    public RewardCountAndPrizeMoney getHitSixTimes() {
        return hitSixTimes;
    }

    public Money getTotalPrizeMoney() {
        return totalPrizeMoney;
    }
}
