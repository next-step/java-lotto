package step3.domain.user;

import step3.domain.lotto.Lottos;
import step3.domain.money.Cache;
import step3.domain.money.Money;

public class User {

    private final String name;
    private final Wallet wallet;

    private Lottos lottos;

    public User(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public Money withDraw() {
        return wallet.withDraw();
    }

    public Money withDraw(Money money) {
        return wallet.withDraw(money);
    }

    public void save(Cache cache) {
        wallet.save(cache);
    }

    public Wallet myWallet() {
        return wallet;
    }

    public void buyLotto(Lottos boughtLottos) {
        this.lottos = boughtLottos;
    }

    public Lottos getLottos() {
        return lottos;
    }
}
