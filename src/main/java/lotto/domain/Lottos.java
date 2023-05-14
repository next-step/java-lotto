package lotto.domain;

import lotto.domain.result.LottoResults;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public LottoResults getLottoResult(Lotto winningNumber) {
        LottoResults lottoResults = LottoResults.of();
        for (Lotto lotto : lottos) {
            lottoResults.win(lotto.getRank(winningNumber));
        }
        return lottoResults;
    }
}
