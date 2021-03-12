package lotto.domain;

import lotto.dto.LotteryTicketDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicketList {

    private final List<LotteryTicket> list = new ArrayList<>();

    public List<LotteryTicketDto> getTicketList() {
        return list.stream().map(LotteryTicketDto::new)
                .collect(Collectors.toList());
    }

    public List<LotteryPrize> match(WinningLotteryTicket lastWinningTicket) {
        List<LotteryPrize> lotteryPrizeList = new ArrayList<>();
        list.forEach(lotteryTicket ->
                lotteryPrizeList.add(lotteryTicket.match(lastWinningTicket))
        );
        return lotteryPrizeList;
    }

    public void addAutoBulk(int count, int price) {
        for (int i = 0; i < count; i++) {
            addAuto(price);
        }
    }

    public void add(List<Integer> lotteryTicketNumberList, int price) {
        list.add(new LotteryTicket(lotteryTicketNumberList, price));
    }

    public void addAuto(int price) {
        list.add(LotteryTicket.auto(price));
    }

    public int getTotalPrice() {
        return list.stream()
                .mapToInt(LotteryTicket::getPrice)
                .sum();
    }
}
