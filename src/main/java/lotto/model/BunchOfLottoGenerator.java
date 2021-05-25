package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BunchOfLottoGenerator {
    private final List<Lotto> bunchOfLotto;

    public BunchOfLottoGenerator(int purchasedLottoCount) {
        List<Lotto> bunchOfLotto = new ArrayList<>();

        for (int i = 0; i < purchasedLottoCount; i++) {
            bunchOfLotto.add(new Lotto(LottoNumberGenerator.makeLottoNumber()));
        }

        this.bunchOfLotto = bunchOfLotto;
    }

    public List<Lotto> getBunchOfLotto() {
        return Collections.unmodifiableList(bunchOfLotto);
    }
}
