package lotto.domain;

import lotto.vo.Lottos;
import lotto.vo.Money;

import java.util.Optional;

public class Wallet {

    private final Money myMoney;
    private Lottos lottos;

    private Wallet(Money myMoney) {
        this.myMoney = myMoney;
    }

    public static Wallet create(Money money) {
        return new Wallet(money);
    }

    public Money getMoneyToBuy() {
        return myMoney;
    }

    public Optional<Lottos> getLottos() {
        return Optional.ofNullable(lottos);
    }

    public Lottos buyLotto(LottoSeller lottoSeller) {
        Lottos lottos = lottoSeller.buyLotto(myMoney);
        this.lottos = lottos;
        return this.lottos;
    }
}
