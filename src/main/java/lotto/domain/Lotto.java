package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public Lotteries buy(final Price price) {
        return new Lotteries(publishLottery(price));
    }

    private List<LottoNumbers> publishLottery(final Price price) {
        List<LottoNumbers> lotteries = new ArrayList<>();
        for (int i = 0; i < price.lotteryCount(); i++) {
            lotteries.add(LottoNumberGenerator.generate());
        }
        return lotteries;
    }
}
