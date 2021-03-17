package study.lotto.controller;

import study.lotto.domain.Lotto;
import study.lotto.generator.LottoNumberGenerator;
import study.lotto.generator.NumberGenerator;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 유저와 로또 사이 판매자 역할
 */
public class LottoStore {

    private final NumberGenerator generator;

    public LottoStore() {
        this(new LottoNumberGenerator());
    }

    public LottoStore(NumberGenerator numberGenerator) {
        this.generator = numberGenerator;
    }

    public Lottos buyLotto(final RequestMoney money) {
        int totalLottoCount = money.getTotalLottoCount();
        List<Lotto> collect = makeLotto(totalLottoCount);
        return new Lottos(collect, money);
    }

    private List<Lotto> makeLotto(final int totalLottoCount) {
        return Stream.generate(generator::generate)
                .limit(totalLottoCount)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

}
