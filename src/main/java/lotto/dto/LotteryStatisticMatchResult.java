package lotto.dto;

import lotto.domain.LotteryPrize;

import java.util.List;

public class LotteryStatisticMatchResult {

    private List<LotteryPrize> lotteryPrizeList;

    private int totalPriceOfLotteryTickets;

    private int totalReward;

    public LotteryStatisticMatchResult(List<LotteryPrize> lotteryPrizeList, int totalPriceOfLotteryTickets) {
        this.lotteryPrizeList = lotteryPrizeList;
        this.totalPriceOfLotteryTickets = totalPriceOfLotteryTickets;
        this.totalReward = calculateTotalReward();
    }

    private int calculateTotalReward() {
       return lotteryPrizeList.stream()
                .mapToInt(LotteryPrize::getReward)
                .sum();
    }

    public int getLotteryPrizeCount(LotteryPrize toFindLotteryPrize) {
        long count = this.lotteryPrizeList.stream()
                .filter(lotteryPrize -> lotteryPrize == toFindLotteryPrize)
                .count();
        return (int)count;
    }

    public Double getProfitMargin() {
        return (double) totalReward / totalPriceOfLotteryTickets;
    }


}
