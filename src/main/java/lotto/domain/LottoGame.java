package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class LottoGame {

    private final List<Lotto> lottos;

    public LottoGame(PurchaseAmount purchaseAmount, LottoGenerator lottoGenerator) {
        this.lottos = Stream.generate(lottoGenerator::generate)
                .limit(purchaseAmount.getLottoCount())
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
