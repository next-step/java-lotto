package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;
    private static final LottoNumberGenerator GENERATOR = new LottoNumberGenerator();

    public Lottos(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(GENERATOR.generate()));
        }
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % LOTTO_PRICE != 0) {
            throw new RuntimeException("구입 금액 단위 오류");
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public int purchaseAmount() {
        return count() * LOTTO_PRICE;
    }
}
