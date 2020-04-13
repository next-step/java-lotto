package lotto.domain;

import lotto.dto.ManualLottoOrderSheet;
import lotto.generator.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public LottoMachine() {
    }

    public Lottos purchaseManualLottos(ManualLottoOrderSheet manualLottoOrderSheet) {
        List<Lotto> lottos = new ArrayList<>();

        for (List<Integer> manualLottoOrder : manualLottoOrderSheet.getManualLottoOrders()) {
            lottos.add(Lotto.of(manualLottoOrder));
        }
        return new Lottos(lottos);
    }

    public Lottos purchaseAutomaticLottos(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(Lotto.of(new RandomNumber()));
        }
        return new Lottos(lottos);
    }
}
