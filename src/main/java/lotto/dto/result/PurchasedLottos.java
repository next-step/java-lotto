package lotto.dto.result;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {

    private List<PurchasedLotto> purchasedLottos;

    private PurchasedLottos(List<PurchasedLotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public static PurchasedLottos from(LottoGame lottoGame) {
        List<PurchasedLotto> purchasedLottos = new ArrayList<>();
        for (Lotto lotto : lottoGame.lottos().toList()) {
            purchasedLottos.add(new PurchasedLotto(lotto));
        }
        return new PurchasedLottos(purchasedLottos);
    }

    public List<PurchasedLotto> lottos() {
        return purchasedLottos;
    }
}
