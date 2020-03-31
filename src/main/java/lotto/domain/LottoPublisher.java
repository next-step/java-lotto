package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPublisher {
    private static final int START_INDEX = 0;

    public LottoPublisher() { }

    public Lotteries publish(final int lotteryCount) {
        List<LottoNumbers> lotteries = new ArrayList<>();
        for (int i = START_INDEX; i < lotteryCount; i++) {
            lotteries.add(LottoNumberGenerator.generate());
        }
        return new Lotteries(lotteries);
    }
}
