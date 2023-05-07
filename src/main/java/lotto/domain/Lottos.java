package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.purchase.PurchaseAuto;

public class Lottos {

    private final List<Lotto> lottos;
    private final int manualCount;
    private final int autoCount;

    public Lottos(List<Lotto> lottos, int manualCount, int autoCount) {
        this.lottos = lottos;
        this.manualCount = manualCount;
        this.autoCount = autoCount;
    }

    public static Lottos of(List<Lotto> lottos, LottoAmount amount) {
        if (lottos == null) {
            lottos = new ArrayList<>();
        }
        int manualCount = lottos.size();
        int count = amount.count();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.newInstance(PurchaseAuto.instance()));
        }
        return new Lottos(lottos, manualCount, count);
    }

    public int count() {
        return lottos.size();
    }

    public int manualCount() {
        return manualCount;
    }

    public int autoCount() {
        return autoCount;
    }

    public List<Lotto> lottos() {
        return new ArrayList<>(lottos);
    }

}
