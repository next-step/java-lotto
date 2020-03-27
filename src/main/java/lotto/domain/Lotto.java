package lotto.domain;

import lotto.dto.Price;

public class Lotto {
    public LotteryTickets buy(final Price price) {
        return new LotteryTickets(price);
    }
}
