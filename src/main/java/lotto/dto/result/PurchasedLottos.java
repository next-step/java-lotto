package lotto.dto.result;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {

    private List<PurchasedLotto> purchasedLottos;
    private int manualLottoCount;
    private int autoLottoCount;

    private PurchasedLottos(List<PurchasedLotto> purchasedLottos, int manualLottoCount, int autoLottoCount) {
        this.purchasedLottos = purchasedLottos;
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = autoLottoCount;
    }

    public static PurchasedLottos from(LottoGame lottoGame) {
        List<PurchasedLotto> purchasedLottos = new ArrayList<>();
        for (Lotto lotto : lottoGame.lottos().toList()) {
            purchasedLottos.add(new PurchasedLotto(lotto));
        }
        return new PurchasedLottos(purchasedLottos, lottoGame.manualLottoCount(), lottoGame.autoLottoCount());
    }

    public List<PurchasedLotto> lottos() {
        return purchasedLottos;
    }

    public int manualLottoCount() {
        return manualLottoCount;
    }

    public int autoLottoCount() {
        return autoLottoCount;
    }
}
