package lotto.model;

import lotto.util.BunchOfLottoGenerator;

import java.util.Collections;
import java.util.List;

public class BunchOfLotto {
    private final List<Lotto> bunchOfLotto;

    public BunchOfLotto(int purchasedLottoCount) {

        this.bunchOfLotto = BunchOfLottoGenerator.makeBunchOfLotto(purchasedLottoCount);
    }

    public List<Lotto> getBunchOfLotto() {
        return Collections.unmodifiableList(bunchOfLotto);
    }
}
