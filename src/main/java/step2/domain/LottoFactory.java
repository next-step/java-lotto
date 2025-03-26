package step2.domain;

import step2.util.LottoStrategy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final int LOTTO_PRICE = 1000;

    private final LottoStrategy lottoStrategy;

    public LottoFactory(LottoStrategy lottoStrategy) {
        this.lottoStrategy = lottoStrategy;
    }

    public Lottos buy(int money) {
        return new Lottos(
                IntStream.range(0, getCount(money))
                .mapToObj(i -> new Lotto(lottoStrategy.generateLottoNumbers()))
                .collect(Collectors.toList()));
    }

    private int getCount(int money) {
        return money / LOTTO_PRICE;
    }

}
