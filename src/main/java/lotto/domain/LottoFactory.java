package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    private LottoFactory() {

    }

    public static List<Lotto> createRandomLottos(int purchaseAmount,
        LottoNumberGenerator generator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(generator));
        }
        return lottos;
    }
}
