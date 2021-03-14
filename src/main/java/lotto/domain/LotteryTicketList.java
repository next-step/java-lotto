package lotto.domain;

import lotto.dto.LotteryTicketListDto;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicketList {

    private final List<LotteryTicket> list = new ArrayList<>();

    public LotteryTicketListDto getTicketList() {
        return new LotteryTicketListDto(list);
    }

    public void setLotteryPrize(WinningLotteryTicket lastWinningTicket) {
        list.forEach(lotteryTicket -> lotteryTicket.setLotteryPrize(lastWinningTicket));
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

    public void addManualBulk(List<List<Integer>> listOfManualLotteryNumberList, int price) {
        for (List<Integer> lotteryNumberList : listOfManualLotteryNumberList) {
            add(lotteryNumberList, price);
        }
    }
}
