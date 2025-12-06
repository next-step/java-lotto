package lotto.domain;

import java.util.stream.Collectors;

public class LottoGame {
    private final Lottos lottos;

    public LottoGame(long amount) {
        this(new Money(amount));
    }

    public LottoGame(Money money) {
        this(new Lottos(money.buyCount()));
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
