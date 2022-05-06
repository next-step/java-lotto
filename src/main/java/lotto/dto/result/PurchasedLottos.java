package lotto.dto.result;

import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {

    private List<PurchasedLotto> purchasedLottos;

    private PurchasedLottos(List<PurchasedLotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public static PurchasedLottos from(LottoBuyer lottoBuyer) {
        List<PurchasedLotto> purchasedLottos = new ArrayList<>();
        for (Lotto lotto : lottoBuyer.lottos().toList()) {
            purchasedLottos.add(new PurchasedLotto(lotto));
        }
        return new PurchasedLottos(purchasedLottos);
    }

    public List<PurchasedLotto> lottos() {
        return purchasedLottos;
    }
}
