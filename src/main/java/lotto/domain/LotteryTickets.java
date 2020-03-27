package lotto.domain;

import java.util.List;

public class LotteryTickets {
    private final List<Lottery> lotteryTickets;

    public LotteryTickets(final List<Lottery> lotteries) {
        this.lotteryTickets = lotteries;
    }

    public int count() {
        return lotteryTickets.size();
    }
}
