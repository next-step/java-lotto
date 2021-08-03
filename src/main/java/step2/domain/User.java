package step2.domain;

import java.util.List;

public class User {

    private final String name;
    private final Wallet wallet;
    
    public User(String name, Wallet wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public List<Lotto> buyLotto(LottoMachine lottoMachine) {
        return lottoMachine.createLottos(wallet);
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
}
