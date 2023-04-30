package study.lotto.step2.application;

import study.lotto.step2.domain.Lotto;
import study.lotto.step2.domain.LottoFactory;
import study.lotto.step2.domain.SoldLottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoSeller {
    private static final long LOTTO_PRICE = 1_000L;
    private final LottoFactory lottoFactory;

    public LottoSeller(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public SoldLottos sell(long amount) {
        return new SoldLottos(lottos(numberOfSelling(amount)));
    }

    private long numberOfSelling(long amount) {
        validateAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private void validateAmount(long amount) {
        if(amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 구입 금액은 " + LOTTO_PRICE + "원입니다: " + amount);
        }
    }

    private List<Lotto> lottos(long numberOfLotto) {
        return LongStream.rangeClosed(1, numberOfLotto)
                .mapToObj(index -> lottoFactory.lotto())
                .collect(Collectors.toList());
    }
}
