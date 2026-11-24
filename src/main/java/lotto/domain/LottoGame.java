package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class LottoGame {

    private final PurchaseAmount purchaseAmount;
    private final List<Lotto> lottos;

    public LottoGame(PurchaseAmount purchaseAmount, LottoGenerator lottoGenerator) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = Stream.generate(lottoGenerator::generate)
                .limit(purchaseAmount.getLottoCount())
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult getResult(WinningLotto winningLotto) {
        List<Rank> ranks = lottos.stream()
                .map(winningLotto::match)
                .toList();
        return new LottoResult(ranks, purchaseAmount);
    }
}
