package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Lottos lottos;
    private final LottoPublisher lottoPublisher;

    public Game(Positive count, Lottos selfLottos, LottoPublisher lottoPublisher) {
        this.lottoPublisher = lottoPublisher;

        Positive autoLottoCount = count.minus(selfLottos.size());
        this.lottos = selfLottos.concat(createLottoList(autoLottoCount));
    }

    public Game(Positive count, LottoPublisher lottoPublisher) {
        this.lottoPublisher = lottoPublisher;
        this.lottos = createLottoList(count);
    }

    private Lottos createLottoList(Positive count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count.get(); i++) {
            result.add(new Lotto(lottoPublisher.get()));
        }
        return new Lottos(result);
    }

    public LottoResult play(Lotto winNumbers, LottoNumber bonusNumber) {
        List<Prize> prizes = lottos.winPrizes(winNumbers, bonusNumber);
        return new LottoResult(prizes);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
