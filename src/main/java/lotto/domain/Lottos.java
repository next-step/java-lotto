package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public static Lottos generate(int count, LottoGenerator lottoGenerator) {
        return new Lottos(Stream.generate(lottoGenerator::generate)
                .limit(count)
                .toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult getResult(WinningLotto winningLotto, PurchaseAmount purchaseAmount) {
        List<Rank> ranks = lottos.stream()
                .map(winningLotto::match)
                .toList();
        return new LottoResult(ranks, purchaseAmount);
    }
}
