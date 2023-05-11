package lotto.domain;

import java.util.ArrayList;

public class CombinedLottos {
    private final int autoLottoQuantity;
    private final int manualLottoQuantity;
    private final Lottos combinedLottos;

    public CombinedLottos(Lottos manualLottos, Lottos autoLottos) {
        this.manualLottoQuantity = manualLottos.getLottoQuantity();
        this.autoLottoQuantity = autoLottos.getLottoQuantity();
        this.combinedLottos = concat(manualLottos, autoLottos);
    }

    public int getAutoLottoQuantity() {
        return autoLottoQuantity;
    }

    public int getManualLottoQuantity() {
        return manualLottoQuantity;
    }

    public Lottos getCombinedLottos() {
        return combinedLottos;
    }

    private Lottos concat(Lottos manualLottos, Lottos autoLottos) {
        ArrayList<Lotto> lottoArrayList = new ArrayList<>();
        lottoArrayList.addAll(manualLottos.getLottoList());
        lottoArrayList.addAll(autoLottos.getLottoList());
        return new Lottos(lottoArrayList);
    }
}
