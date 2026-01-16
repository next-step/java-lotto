package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoPurchase {
    private static final long LOTTO_PRICE = 1_000;
    private final Money money;
    private final List<String> manualLottos;

    public LottoPurchase(LottoCount count) {
        this(new Money(count.value() * LOTTO_PRICE));
    }

    public LottoPurchase(Money money) {
        this(money, Collections.emptyList());
    }

    public LottoPurchase(Money money, List<String> manualList) {
        this.money = money;
        this.manualLottos = manualList;
    }

    public Lottos purchase() {
        LottoGenerator bundleGenerator = new LottosBundleGenerator(money, manualLottos);
        return bundleGenerator.generate();
    }

    public int count() {
        return (int) (money.getMoney() / LOTTO_PRICE);
    }
}
