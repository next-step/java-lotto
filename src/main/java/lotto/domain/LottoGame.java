package lotto.domain;

import java.util.List;

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

    public List<Lotto> lottos() {
        return lottos.values();
    }

    public LottoResult check(WinningLotto winningLotto) {
        return lottos.findResult(winningLotto);
    }

    public double rateOfReturn(LottoResult result) {
        return money.rateOfReturn(result.getTotal());
    }
}
