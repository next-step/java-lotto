package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> manualLottos;
    private final List<Lotto> autoLottos;

    public Lottos(List<Lotto> lottos) {
        this(lottos, null);
    }

    public Lottos(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        this.manualLottos = manualLottos;
        this.autoLottos = autoLottos;
    }

    public static Lottos create(MyPurchase myPurchase, List<LottoNumbers> manualLottos) {
        List<Lotto> manual = new ArrayList<>();
        if (manualLottos != null) {
            manualLottos.forEach(lottoNumbers -> manual.add(Lotto.manualGenerate(lottoNumbers)));
        }
        List<Lotto> auto = new ArrayList<>();
        for (int i = 0; i < myPurchase.autoCount(); i++) {
            auto.add(Lotto.autoGenerate());
        }
        return new Lottos(manual, auto);
    }

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }

    public List<Lotto> getAutoLottos() {
        return autoLottos;
    }

    public void checkWin(MyResult myResult, WinLotto winLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : manualLottos) {
            ranks.add(winLotto.checkRank(lotto));
        }
        for (Lotto lotto : autoLottos) {
            ranks.add(winLotto.checkRank(lotto));
        }
        myResult.update(ranks);
    }

    public int size() {
        return manualLottos.size()+autoLottos.size();
    }
}
