package lotto.step3.domain;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(LottoStrategy lottoStrategy, LottoCount lottCount) {
        this.lottos = createLottos(lottoStrategy, lottCount);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> createLottos(LottoStrategy lottoStrategy, LottoCount lottCount) {
        return lottCount.play(lottoStrategy);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
