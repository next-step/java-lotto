package lotto.domain;

import java.util.List;

public class LottoManager {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;


    public LottoManager(List<Lotto> lottos) {
        validate(lottos);

        this.lottos = lottos;
    }

    private void validate(List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException("로또를 한장이상 구매해주세요");
        }
    }

    public int countPurchasedLottos() {
        return lottos.size();
    }

    public int purchaseAmount() {
        return lottos.size() * LOTTO_PRICE;
    }

    public List<Lotto> purchasedLottos() {
        return lottos;
    }
}
