package step2.domain;

import java.util.List;

public class User {

    private final String name;
    private final Wallet wallet;

    private List<Lotto> lottos;

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

    public void buyLotto(LottoMachine lottoMachine) {
        this.lottos = lottoMachine.sell(myWallet().currentMoney());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
