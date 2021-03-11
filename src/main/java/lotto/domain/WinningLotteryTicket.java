package lotto.domain;

import java.util.List;

public class WinningLotteryTicket {

    private final Lottery lottery;

    public WinningLotteryTicket(List<Integer> numberList) {
        this.lottery = new Lottery(numberList);
    }

    public Lottery getLottery() {
        return lottery;
    }

}
