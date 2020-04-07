package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public LottoMachine() {
    }

    public Lottos purchaseManualLottos(ManualLottoOrderSheet manualLottoOrderSheet) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoOrderSheet.getOrderCount(); i++) {
            lottos.add(Lotto.manual(manualLottoOrderSheet.getManualLottoOrders().get(i)));
        }
        return new Lottos(lottos);
    }

    public Lottos purchaseAutomaticLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(Lotto.automatic());
        }
        return new Lottos(lottos);
    }
}
