package lotto.dto;

import lotto.domain.Money;

public class WinLotteryResult {
    private final RewardCountAndPrizeMoney firstRank;
    private final RewardCountAndPrizeMoney secondRank;
    private final RewardCountAndPrizeMoney thirdRank;
    private final RewardCountAndPrizeMoney fourthRank;
    private final RewardCountAndPrizeMoney fifthRank;
    private final Money totalPrizeMoney;

    public WinLotteryResult(final RewardCountAndPrizeMoney firstRank,
                            final RewardCountAndPrizeMoney secondRank,
                            final RewardCountAndPrizeMoney thirdRank,
                            final RewardCountAndPrizeMoney fourthRank,
                            final RewardCountAndPrizeMoney fifthRank,
                            final Money totalPrizeMoney) {
        this.firstRank = firstRank;
        this.secondRank = secondRank;
        this.thirdRank = thirdRank;
        this.fourthRank = fourthRank;
        this.fifthRank = fifthRank;
        this.totalPrizeMoney = totalPrizeMoney;
    }

    public RewardCountAndPrizeMoney getFirstRank() {
        return firstRank;
    }

    public RewardCountAndPrizeMoney getSecondRank() {
        return secondRank;
    }

    public RewardCountAndPrizeMoney getThirdRank() {
        return thirdRank;
    }

    public RewardCountAndPrizeMoney getFourthRank() {
        return fourthRank;
    }

    public RewardCountAndPrizeMoney getFifthRank() {
        return fifthRank;
    }

    public Money getTotalPrizeMoney() {
        return totalPrizeMoney;
    }
}
