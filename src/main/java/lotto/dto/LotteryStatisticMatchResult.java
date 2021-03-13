package lotto.dto;

import lotto.domain.LotteryPrize;
import lotto.domain.LotteryTicketList;

import java.util.List;

public class LotteryStatisticMatchResult {

    private List<LotteryTicketDto> lotteryTicketDtoList;

    private int totalPriceOfLotteryTickets;

    private int totalReward;

    public LotteryStatisticMatchResult(LotteryTicketList lotteryTicketList) {
        this.lotteryTicketDtoList = lotteryTicketList.getTicketList();
        this.totalPriceOfLotteryTickets = lotteryTicketList.getTotalPrice();
        this.totalReward = calculateTotalReward();
    }

    private int calculateTotalReward() {
        return lotteryTicketDtoList.stream()
                .mapToInt(lotteryTicketDto -> lotteryTicketDto.getLotteryPrize().getReward())
                .sum();
    }

    public int getLotteryPrizeCount(LotteryPrize toFindLotteryPrize) {
        long count = lotteryTicketDtoList.stream()
                .filter(lotteryTicketDto -> lotteryTicketDto.getLotteryPrize() == toFindLotteryPrize)
                .count();
        return (int) count;
    }

    public Double getProfitMargin() {
        return (double) totalReward / totalPriceOfLotteryTickets;
    }


}
