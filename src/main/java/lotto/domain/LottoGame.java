package lotto.domain;

import java.util.stream.Collectors;

public class LottoGame {
    private final Lottos lottos;
    private final Money money;

    public LottoGame(long amount) {
        this(new Money(amount));
    }

    public LottoGame(Money money) {
        this(new Lottos(money.buyCount()), money);
    }

    public LottoGame(Lottos lottos, Money money) {
        this.lottos = lottos;
        this.money = money;
    }

    public LottoResult findWinner(WinningLotto winningLotto) {
        return lottos.findResult(winningLotto);
    }

    public double rateOfReturn(LottoResult result) {
        return result.profitRate(money);
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
