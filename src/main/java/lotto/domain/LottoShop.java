package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoShop {
    private final static int LOTTO_PRICE = 1000;

    private final LottoNumberStrategy lottoNumberStrategy;
    private final Money payed;
    private final int manualPurchaseCount;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoShop(LottoNumberStrategy lottoNumberStrategy, final Money payed, final int manualPurchaseCount) {
        if(payed.calculateQuantity(LOTTO_PRICE) < manualPurchaseCount){
            throw new IllegalArgumentException("수동 구입분이 입력 금액을 초과 했습니다.");
        }
        this.payed = payed;
        this.lottoNumberStrategy = lottoNumberStrategy;
        this.manualPurchaseCount = manualPurchaseCount;
    }

    public Lottos buy() {
        for (int i = 0; i < numberOfPurchasingAuto(); i++) {
            lottos.add(Lotto.create(lottoNumberStrategy));
        }
        return new Lottos(lottos);
    }

    public int numberOfPurchasingAuto() {
        return payed.calculateQuantity(LOTTO_PRICE) - manualPurchaseCount;
    }

    public void buyManually(Set<Number> numbers) {
        lottos.add(new Lotto(numbers));
    }
}
