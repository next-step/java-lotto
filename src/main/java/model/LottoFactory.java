package model;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static Lottos create(final LottoAmount lottoAmount) {
        final int purchaseCount = lottoAmount.calculateLottoPurchaseCount();
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }
        return new Lottos(lottos);
    }
}
