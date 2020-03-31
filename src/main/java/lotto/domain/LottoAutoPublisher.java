package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoPublisher implements LottoPublisher {
    private static final int START_INDEX = 0;

    private int count;

    public LottoAutoPublisher(int count) {
        this.count = count;
    }

    @Override
    public Lotteries publish() {
        List<LottoNumbers> lotteries = new ArrayList<>();
        for (int i = START_INDEX; i < count; i++) {
            lotteries.add(LottoNumberGenerator.generate());
        }
        return new Lotteries(lotteries);
    }
}
