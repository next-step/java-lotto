package lotto.dto;

import lotto.domain.LotteryPrize;

public class LotteryStatisticMatchResult {

    private LotteryPrizeResult firstPrizeLotteryResult;

    private LotteryPrizeResult secondPrizeLotteryResult;

    private LotteryPrizeResult thirdPrizeLotteryResult;

    private LotteryPrizeResult fourthPrizeLotteryResult;

    private int totalReward;

    private int totalPriceOfLotteryTickets;

    public LotteryStatisticMatchResult(LotteryMatchResult matchResult, int totalPriceOfLotteryTickets) {
        this.totalPriceOfLotteryTickets = totalPriceOfLotteryTickets;
        setLotteryPrizeResult(matchResult);
        calculateTotalReward();
    }

    private void setLotteryPrizeResult(LotteryMatchResult matchResult) {
        firstPrizeLotteryResult = new LotteryPrizeResult(LotteryPrize.FIRST,matchResult);
        secondPrizeLotteryResult = new LotteryPrizeResult(LotteryPrize.SECOND,matchResult);
        thirdPrizeLotteryResult = new LotteryPrizeResult(LotteryPrize.THIRD,matchResult);
        fourthPrizeLotteryResult = new LotteryPrizeResult(LotteryPrize.FOURTH,matchResult);
    }


    private void calculateTotalReward() {
        totalReward = firstPrizeLotteryResult.getTotalReward();
        totalReward += secondPrizeLotteryResult.getTotalReward();
        totalReward += thirdPrizeLotteryResult.getTotalReward();
        totalReward += fourthPrizeLotteryResult.getTotalReward();
    }

    public Double getProfitMargin() {
       return (double)totalPriceOfLotteryTickets / totalReward;
    }
}
