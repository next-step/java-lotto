package lotto.domain;

public class CombinedLottos {
    private final int autoLottoQuantity;
    private final int manualLottoQuantity;
    private final Lottos combinedLottos;

    public CombinedLottos(Lottos manualLottos, Lottos autoLottos) {
        this.manualLottoQuantity = manualLottos.getLottoQuantity();
        this.autoLottoQuantity = autoLottos.getLottoQuantity();
        this.combinedLottos = Lottos.concat(manualLottos, autoLottos);
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
}
