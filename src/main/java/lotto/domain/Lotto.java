package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public Lotteries buy(final Price price) {
        List<Lottery> lotteries = publishLottery(price);
        return new Lotteries(lotteries);
    }

    private List<Lottery> publishLottery(final Price price) {
        List<Lottery> lotteries = new ArrayList<>();
        for (int i = 0; i < price.lotteryCount(); i++) {
            lotteries.add(new Lottery(LottoNumberGenerator.generate()));
        }
        return lotteries;
    }
}
