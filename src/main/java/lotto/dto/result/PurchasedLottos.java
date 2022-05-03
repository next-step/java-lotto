package lotto.dto.result;

import lotto.domain.LottoBuyer;
import lotto.domain.Lottos;

public class PurchasedLottos {

    private Lottos lottos;

    private PurchasedLottos(Lottos lottos) {
        this.lottos = lottos;
    }

    public static PurchasedLottos of(LottoBuyer lottoBuyer) {
        return new PurchasedLottos(lottoBuyer.lottos());
    }

    public Lottos lottos() {
        return lottos;
    }
}
