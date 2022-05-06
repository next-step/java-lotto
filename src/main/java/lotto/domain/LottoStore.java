package lotto.domain;

import lotto.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;
    private final int availablePurchaseLottoCount;

    public LottoStore(int purchasePrice) {
        this.availablePurchaseLottoCount = purchasePrice / LOTTO_PRICE;
    }

    public Lottos sellLotto() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < availablePurchaseLottoCount; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }
        return new Lottos(lottos);
    }
}
