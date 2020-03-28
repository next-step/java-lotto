package lotto.domain;

import java.util.List;

public class Lotteries {
    private final List<Lottery> lotteryTickets;

    public Lotteries(final List<Lottery> lotteries) {
        this.lotteryTickets = lotteries;
    }

    public int count() {
        return lotteryTickets.size();
    }
}
