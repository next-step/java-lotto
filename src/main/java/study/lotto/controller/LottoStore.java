package study.lotto.controller;

import study.lotto.domain.Lotto;
import study.lotto.generator.LottoNumberGenerator;
import study.lotto.generator.NumberGenerator;
import study.lotto.service.Lottos;
import study.lotto.view.dto.RequestMoney;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static study.lotto.view.InputView.WHITE_SPACE;

/**
 * 유저와 로또 사이 판매자 역할
 */
public class LottoStore {

    private final NumberGenerator generator;

    public LottoStore() {
        this(new LottoNumberGenerator());
    }

    public LottoStore(final NumberGenerator numberGenerator) {
        this.generator = numberGenerator;
    }

    private List<Lotto> autoLotto(final Lottos manualLotto, final int totalLottoCount) {
        List<Lotto> autoLottos = Stream.generate(() -> generator.generate(WHITE_SPACE))
                .limit(totalLottoCount)
                .map(Lotto::new)
                .collect(toList());
        return manualLotto.addAll(autoLottos);
    }

    public Lottos lotto(final RequestMoney money, final Lottos manualLotto) {
        int totalLottoCount = money.autoCount();
        List<Lotto> sortLottos = autoLotto(manualLotto, totalLottoCount);
        return new Lottos(sortLottos, money);
    }

    public Lotto manualLotto(final String manualNumbers) {
        return new Lotto(generator.generate(manualNumbers));
    }
}
