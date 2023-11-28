package step2.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import step2.lotto.strategy.LottoNumberGenerator;
import step2.lotto.strategy.LottoNumberManualGenerator;
import step2.lotto.strategy.LottoNumberRandomGenerator;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public static Lottos purchaseLottos(final LottoPurchase lottoPurchase) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(createLottos(lottoPurchase, new LottoNumberRandomGenerator()));
        lottos.addAll(createLottos(lottoPurchase, new LottoNumberManualGenerator()));
        return new Lottos(lottos);
    }

    private static List<Lotto> createLottos(final LottoPurchase purchase,
        final LottoNumberGenerator lottoNumberRandomGenerator) {
        return lottoNumberRandomGenerator.generateLottos(purchase);
    }

}
