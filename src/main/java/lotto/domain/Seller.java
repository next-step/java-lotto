package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private static final Money PRICE = new Money(1000);

    private final List<Lotto> lottos = new ArrayList<>();
    private PurchaseCount count;

    public Seller(int input, int manualLottoCount) {
        this.count = new PurchaseCount(calculateCount(new Money(input)));
        checkValid(this.count, manualLottoCount);
    }

    private void checkValid(PurchaseCount count, int manualLottoCount) {
        if (count.isLessThan(manualLottoCount)) {
            throw new IllegalArgumentException("수동 로또 구입 개수가 투입 금액보다 많습니다.");
        }
    }

    private int calculateCount(Money money) {
        return money.divide(PRICE);
    }

    private void generateLotto(GeneratorStrategy strategy) {
        this.lottos.add(strategy.generate());
        this.count = count.decrease();
    }

    public List<Lotto> generateManual(List<String> manualLottos) {
        for (String manualLotto : manualLottos) {
            generateLotto(new ManualStrategy(manualLotto));
        }
        return lottos;
    }

    public List<Lotto> generateAuto() {
        while (count.isPositive()) {
            generateLotto(new AutomaticStrategy());
        }
        return lottos;
    }

}
