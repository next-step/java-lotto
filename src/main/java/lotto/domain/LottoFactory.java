package lotto.domain;

import java.util.List;
import java.util.function.Supplier;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoFactory {

    private final LottoNumberProduceStrategy strategy;

    public LottoFactory(LottoNumberProduceStrategy strategy) {
        this.strategy = strategy;
    }

    public Lotto produce() {
        return new Lotto(strategy.getLottoNumber());
    }
}
