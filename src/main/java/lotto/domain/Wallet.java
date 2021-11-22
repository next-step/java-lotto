package lotto.domain;

import lotto.vo.Lottos;
import lotto.vo.Money;

public class Wallet {

    private final Money myMoney;
    private final Lottos lottos;

    private Wallet(Money myMoney, Lottos lottos) {
        this.myMoney = myMoney;
        this.lottos = lottos;
    }

    public static Wallet create(Money money, Lottos lottos) {
        return new Wallet(money, lottos);
    }
    public Lottos getLottos() {
        return lottos;
    }

    public Money getMyMoney() {
        return myMoney;
    }
}
