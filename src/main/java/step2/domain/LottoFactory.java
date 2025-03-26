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
        if (money < 1000) {
            throw new IllegalArgumentException("로또 구입은 최소 1000원부터 가능합니다.");
        }
        return new Lottos(
                IntStream.range(0, getCount(money))
                .mapToObj(i -> new Lotto(lottoStrategy.generateLottoNumbers()))
                .collect(Collectors.toList()));
    }

    private int getCount(int money) {
        return money / LOTTO_PRICE;
    }

}
