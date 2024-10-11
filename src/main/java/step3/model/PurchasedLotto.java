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

    //수동로또 추가
    public void addManualLotto(ManualLotto manualLotto) {
        this.purchasedLotto.addAll(manualLotto.getLottoList());
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
