package study.lotto.step2.application;

import study.lotto.step2.domain.Lotto;
import study.lotto.step2.domain.LottoFactory;
import study.lotto.step2.domain.LottoPurchase;
import study.lotto.step2.domain.Lottos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoSeller {
    private final LottoFactory lottoFactory;

    public LottoSeller(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public Lottos sell(LottoPurchase lottoPurchase) {
        return new Lottos(lottos(lottoPurchase));
    }

    private List<Lotto> lottos(LottoPurchase lottoPurchase) {
        return LongStream.rangeClosed(1, lottoPurchase.purchaseSize())
                .mapToObj(index -> lottoFactory.create())
                .collect(Collectors.toList());
    }
}
