package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PurchasedLotto {

    private final List<Lotto> purchasedLotto = new ArrayList<>();

    //로또 추가
    public void addLotto(Lotto lotto) {
        this.purchasedLotto.add(lotto);
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
