package step2.shop;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import step2.lotto.Lotto;
import step2.lotto.Lottos;

public class LottoShop {

    private final LottoNumberGenerationPolicy lottoNumberGenerationPolicy;

    LottoShop(final LottoNumberGenerationPolicy lottoNumberGenerationPolicy) {
        this.lottoNumberGenerationPolicy = lottoNumberGenerationPolicy;
    }

    public Lotto buyAuto() {
        return new Lotto(lottoNumberGenerationPolicy.nextSix());
    }

    public Lottos buyAuto(final int amount) {
        return new Lottos(Stream.generate(() -> new Lotto(lottoNumberGenerationPolicy.nextSix()))
                                .limit(amount)
                                .collect(Collectors.toList()));
    }
}
