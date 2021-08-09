package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount) {
        validatePurchasableAmount(purchaseAmount);

        int lottoCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(new RandomLottoNumberGenerating()));
        }
        this.lottos = lottos;
    }

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void validatePurchasableAmount(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("구입금액은 최소 %d(원) 이상이어야 합니다.", LOTTO_PRICE));
        }
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
