package lottoAuto.model;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResults matchWinningLotto(WinningLotto winningLotto) {
        LottoResults lottoResults = new LottoResults();
        lottos.stream()
                .map(lotto -> lotto.makeLottoResult(winningLotto))
                .forEach(lottoResults::add);

        return lottoResults;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
