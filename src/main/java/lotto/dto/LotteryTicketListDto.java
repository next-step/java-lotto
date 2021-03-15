package lotto.dto;

import lotto.domain.LotteryCreatedType;
import lotto.domain.LotteryPrize;
import lotto.domain.LotteryTicket;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicketListDto {

    private List<LotteryTicketDto> list;

    public LotteryTicketListDto(List<LotteryTicket> ticketList) {
        list = ticketList.stream().map(LotteryTicketDto::new)
                .collect(Collectors.toList());
    }

    public int totalSize() {
        return list.size();
    }

    public int autoSize() {
        long autoSize = list.stream()
                .filter(lotteryTicketDto -> lotteryTicketDto.getCreatedType() == LotteryCreatedType.AUTO)
                .count();
        return (int) autoSize;
    }

    public int manualSize() {
        long manualSize = list.stream()
                .filter(lotteryTicketDto -> lotteryTicketDto.getCreatedType() == LotteryCreatedType.MANUAL)
                .count();
        return (int) manualSize;
    }

    private int calculateTotalReward() {
        return list.stream()
                .mapToInt(lotteryTicketDto -> lotteryTicketDto.getLotteryPrize().getReward())
                .sum();
    }

    private int calculateTotalPrice() {
        return list.stream()
                .mapToInt(LotteryTicketDto::getPrice)
                .sum();
    }

    public int getLotteryPrizeCount(LotteryPrize toFindLotteryPrize) {
        long count = list.stream()
                .filter(lotteryTicketDto -> lotteryTicketDto.getLotteryPrize() == toFindLotteryPrize)
                .count();
        return (int) count;
    }

    public Double getProfitMargin() {
        return (double) calculateTotalReward() / calculateTotalPrice();
    }

    public List<LotteryTicketDto> getList() {
        return list;
    }
}
