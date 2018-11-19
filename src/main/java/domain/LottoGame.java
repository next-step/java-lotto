package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;
    private LottoCountManager lottoCountManager;

    public LottoGame(LottoCountManager lottoCountManager) {
        lottos = new ArrayList<>();
        this.lottoCountManager = lottoCountManager;
    }

    public void buyAuto() {
        for (int i = 0; i < lottoCountManager.autoCount(); i++) {
            lottos.add(Lotto.auto());
        }
    }

    public void buyManual(List<Lotto> manualLottos) {
        if (!manualLottos.isEmpty()) {
            lottos.addAll(manualLottos);
        }
    }

    public List<Lotto> getBoughtLottos() {
        return lottos;
    }
}
