package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int purchasePrice;
    private List<Lotto> lottos = new ArrayList<>();
    private final LottoSeller lottoSeller;

    public User(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public void purchaseLottos(int purchasePrice) {
        assertValidPurchasePrice(purchasePrice);

        int lottoCount = purchasePrice / Lotto.PRICE;
        lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos = lottoSeller.sellLottos(lottoCount);
        }

        this.purchasePrice = purchasePrice;
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    private void assertValidPurchasePrice(int purchasePrice) {
        String errorMessage = String.format("[유저] 로또 가격 %d로 나누어 떨어지는 값을 입력해주세요.", Lotto.PRICE);

        if (purchasePrice < 0 || purchasePrice % Lotto.PRICE > 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
