package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoFactory {

    private final LottoNumberProduceStrategy strategy;

    public LottoFactory(LottoNumberProduceStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Lotto> getLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(getLotto());
        }

        return lottos;
    }

    private Lotto getLotto() {
        return new Lotto(strategy.getLottoNumber());
    }
}
