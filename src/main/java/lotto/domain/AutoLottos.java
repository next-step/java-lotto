package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AutoLottos {

    private static final int ZERO = 0;

    private Money money;

    public AutoLottos(Money money) {
        this.money = money;
    }

    public List<Lotto> getAutoLottos() {
        CreatableLotto lotto = new LottoFactory().createAutoLotto();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = ZERO; i < this.money.purchaseCount(); i++) {
            lottos.add(new Lotto(lotto.makeLotto()));
        }
        return lottos;
    }
}
