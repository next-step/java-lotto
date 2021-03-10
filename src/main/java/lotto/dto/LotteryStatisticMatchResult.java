package lotto.dto;

import lotto.domain.LotteryGameRule;

import java.util.List;

public class LotteryStatisticMatchResult {
    private int firstPrizeLotteryTicketCount;
    private int firstPrizeReward;
    private int secondPrizeLotteryTicketCount;
    private int secondPrizeReward;
    private int thirdPrizeLotteryTicketCount;
    private int thirdPrizeReward;
    private int fourthPrizeLotteryTicketCount;
    private int fourthPrizeReward;

    private int totalReward;
    private int totalPriceOfLotteryTickets;

    public LotteryStatisticMatchResult(LotteryMatchResult matchResult, LotteryGameRule lotteryGameRule) {
        setReward(lotteryGameRule);
        setTicketCount(matchResult);
        List<LotteryTicketDto> firstPrizeWonLotteryTicketList = matchResult.getLotteryTicketListByMatchingCount(lotteryGameRule.getFirstPrizeMatchingCount());
        firstPrizeReward=lotteryGameRule.getFirstPrizeReward();
        calculateTotalReward();
    }

    private void setTicketCount(LotteryMatchResult matchResult,LotteryGameRule lotteryGameRule) {
        firstPrizeLotteryTicketCount = matchResult.getLotteryTicketListCountByMatchingCount(lotteryGameRule.getFirstPrizeMatchingCount());
        secondPrizeLotteryTicketCount = matchResult.getLotteryTicketListCountByMatchingCount(lotteryGameRule.getSecondPrizeMatchingCount());
        thirdPrizeLotteryTicketCount = matchResult.getLotteryTicketListCountByMatchingCount(lotteryGameRule.getThirdPrizeMatchingCount());
        fourthPrizeLotteryTicketCount = matchResult.getLotteryTicketListCountByMatchingCount(lotteryGameRule.getFourthPrizeMatchingCount());
    }

    private void setReward(LotteryGameRule lotteryGameRule) {
        firstPrizeReward=lotteryGameRule.getFirstPrizeReward();
        secondPrizeReward=lotteryGameRule.getSecondPrizeReward();
        thirdPrizeReward=lotteryGameRule.getThirdPrizeReward();
        fourthPrizeReward=lotteryGameRule.getFourthPrizeReward();
    }

    private void calculateTotalReward() {
        totalReward += firstPrizeReward * firstPrizeLotteryTicketCount;
        totalReward += secondPrizeReward * secondPrizeLotteryTicketCount;
        totalReward += thirdPrizeReward * thirdPrizeLotteryTicketCount;
        totalReward += fourthPrizeReward * fourthPrizeLotteryTicketCount;
    }
}
