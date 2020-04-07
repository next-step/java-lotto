package lotto.domain;

import lotto.generator.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public LottoMachine() {
    }

    public Lottos purchaseManualLottos(ManualLottoOrderSheet manualLottoOrderSheet) {
        List<Lotto> lottos = new ArrayList<>();

        for (List<Integer> manualLottoOrder : manualLottoOrderSheet.getManualLottoOrders()) {
            lottos.add(Lotto.manual(manualLottoOrder));
        }
        return new Lottos(lottos);
    }

    public Lottos purchaseAutomaticLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(Lotto.automatic(new RandomNumber()));
        }
        return new Lottos(lottos);
    }
}
