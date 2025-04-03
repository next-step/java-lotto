package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private static final Money PRICE = new Money(1000);

    private final List<Lotto> lottos = new ArrayList<>();
    private PurchaseCount count;

    public Seller(int input) {
        this(input, new ArrayList<>());
    }

    public Seller(int input, List<String> manualLottos) {
        this.count = new PurchaseCount(calculateCount(new Money(input)));
        this.generateManual(manualLottos);
    }

    private int calculateCount(Money money) {
        return money.divide(PRICE);
    }

    private void generateManual(List<String> manualLottos) {
        for (String manualLotto : manualLottos) {
            this.lottos.add(new ManualStrategy(manualLotto).generate());
            this.count = count.decrease();
        }
    }

    public List<Lotto> generateLottos() {
        while (count.isPositive()) {
            this.lottos.add(new AutomaticStrategy().generate());
            this.count = count.decrease();
        }
        return lottos;
    }
}
