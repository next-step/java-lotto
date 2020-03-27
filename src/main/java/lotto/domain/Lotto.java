package lotto.domain;

import lotto.dto.Price;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    public LotteryTickets buy(final Price price) {
        List<Lottery> lotteryList = Arrays.asList(new Lottery(), new Lottery());
        return new LotteryTickets(lotteryList);
    }
}
