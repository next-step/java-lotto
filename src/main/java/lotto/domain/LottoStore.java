package lotto.domain;

import lotto.factory.LottoFactory;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public List<Lotto> buyLottos(int price, Lottos manualLottos) {

        int autoLottoCount = calculateCount(price, manualLottos.getCount());
        List<Lotto> lottos = new ArrayList<>();

        buyManualLottos(manualLottos, lottos);
        butAutoLottos(autoLottoCount, lottos);

        return lottos;
    }

    private static void butAutoLottos(int autoLottoCount, List<Lotto> lottos) {
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(LottoFactory.issueLotto());
        }
    }

    private static void buyManualLottos(Lottos manualLottos, List<Lotto> lottos) {
        lottos.addAll(manualLottos.getLottos());
    }

    private static int calculateCount(int price, int manualLottoCount) {
        return price / 1000 - manualLottoCount;
    }
}
