package lotto.domain;

import lotto.dto.Price;

public class Lotto {
    public int buy(final Price price) {
        return price.lotteryCount();
    }
}
