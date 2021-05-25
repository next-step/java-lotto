package lotto.util;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class BunchOfLottoGenerator {

    private BunchOfLottoGenerator() {
    }

    public static List<Lotto> makeBunchOfLotto(int purchasedLottoCount) {
        List<Lotto> bunchOfLotto = new ArrayList<>();

        for (int i = 0; i < purchasedLottoCount; i++) {
            bunchOfLotto.add(new Lotto(LottoNumberGenerator.makeLottoNumber()));
        }

        return bunchOfLotto;
    }
}
