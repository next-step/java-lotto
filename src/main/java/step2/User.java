package step2;

import java.util.List;

public class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public List<Lotto> buyLotto(Integer givenWallet) {
        return LottoMachine.createLottos(givenWallet);
    }
}
