package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(MyPurchase myPurchase, List<Numbers> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < myPurchase.manualCount(); i++) {
            lottos.add(Lotto.manualGenerate(manualLottos.get(i)));
        }
        for (int i = 0; i < myPurchase.autoCount(); i++) {
            lottos.add(Lotto.autoGenerate());
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void checkWin(MyResult myResult, WinLotto winLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(winLotto.checkRank(lotto));
        }
        myResult.update(ranks);
    }
}
