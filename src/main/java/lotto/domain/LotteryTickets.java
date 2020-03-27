package lotto.domain;

import lotto.dto.Price;

public class LotteryTickets {
    private Price price;
    public LotteryTickets(final Price price) {
        this.price = price;
    }

    public int count() {
        return price.lotteryCount();
    }
}
