package lotto.domain;

import java.util.stream.Collectors;

public class LottoGame {
    private final Lottos lottos;

    public LottoGame(LottoPurchase purchase) {
        this(purchase.toLottos());
    }

    public LottoGame(Lottos lottos) {
        this.lottos = lottos;
    }

    public LottoResult findWinner(WinningLotto winningLotto) {
        return lottos.findResult(winningLotto);
    }

    public int lottoCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.values().stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
