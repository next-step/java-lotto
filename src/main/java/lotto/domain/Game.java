package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Lottos lottos;
    private final LottoPublisher lottoPublisher;

    public Game(Positive count, LottoPublisher lottoPublisher) {
        this(count, new Lottos(new ArrayList<>()), lottoPublisher);
    }

    public Game(Positive count, Lottos selfLottos, LottoPublisher lottoPublisher) {
        this.lottoPublisher = lottoPublisher;

        Positive autoLottoCount = count.minus(selfLottos.size());
        this.lottos = selfLottos.concat(createLottoList(autoLottoCount));
    }

    private Lottos createLottoList(Positive count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count.get(); i++) {
            result.add(lottoPublisher.get());
        }
        return new Lottos(result);
    }

    public LottoResult play(Lotto winNumbers, LottoNumber bonusNumber) {
        return lottos.winPrizes(winNumbers, bonusNumber);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
