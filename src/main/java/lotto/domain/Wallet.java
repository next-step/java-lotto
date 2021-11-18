package lotto.domain;

import lotto.vo.Lottos;
import lotto.vo.Money;

public class Wallet {

    private Lottos lottos;
    private final Money myMoney;

    private Wallet(Money myMoney) {
        this.myMoney = myMoney;
    }

    public static Wallet create(Money money) {
        return new Wallet(money);
    }

    public Money getMoneyToBuy() {
        return myMoney;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public void saveLottos(Lottos lottos) {
        this.lottos = lottos;
    }
}
