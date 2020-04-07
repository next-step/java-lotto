package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public LottoMachine() {
    }

    public List<Lotto> purchaseManualLottos(ManualLottoOrderSheet manualLottoOrderSheet) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoOrderSheet.getOrderCount(); i++) {
            lottos.add(Lotto.manual(manualLottoOrderSheet.getManualLottoOrders().get(i)));
        }
        return lottos;
    }

    public List<Lotto> purchaseAutomaticLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(Lotto.automatic());
        }
        return lottos;
    }
}
