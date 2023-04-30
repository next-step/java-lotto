package study.lotto.step2.application;

import study.lotto.step2.domain.Lotto;
import study.lotto.step2.domain.LottoFactory;
import study.lotto.step2.domain.SoldLottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {
    private static final int LOTTO_PRICE = 1_000;
    private final LottoFactory lottoFactory;

    public LottoSeller(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public SoldLottos sell(int amount) {
        return new SoldLottos(lottos(numberOfSelling(amount)));
    }

    private int numberOfSelling(int amount) {
        validateAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private void validateAmount(int amount) {
        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 구입 금액은 " + LOTTO_PRICE + "원입니다: " + amount);
        }
    }

    private List<Lotto> lottos(int numberOfLotto) {
        return IntStream.rangeClosed(1, numberOfLotto)
                .mapToObj(index -> lottoFactory.lotto())
                .collect(Collectors.toList());
    }
}
