package lotto.domain;

import lotto.dto.Price;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public LotteryTickets buy(final Price price) {
        List<Lottery> lotteries = makeLottery(price);
        return new LotteryTickets(lotteries);
    }

    private List<Lottery> makeLottery(final Price price) {
        List<Lottery> lotteries = new ArrayList<>();
        final int lotteryCount = price.lotteryCount();
        for (int i = 0; i < lotteryCount; i++) {
            lotteries.add(new Lottery());
        }
        return lotteries;
    }
}
