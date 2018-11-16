package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    private List<Lotto> lottos;
    private Money money;

    private LottoWallet(Money money, List<Lotto> lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public static LottoWallet create(Money money) {
        return new LottoWallet(money, new ArrayList<>());
    }

    public static LottoWallet create(Money money, List<Lotto> lottos) {
        return new LottoWallet(money, lottos);
    }

    public Money getMoney() {
        return money;
    }

    public List<Lotto> getManualLottos() {
        return lottos;
    }
}
