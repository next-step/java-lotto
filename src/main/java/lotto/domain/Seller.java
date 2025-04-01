package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private static final Money PRICE = new Money(1000);

    private final List<String> manualLottos;
    private PurchaseCount count;

    public Seller(int input) {
        this(input, new ArrayList<>());
    }

    public Seller(int input, List<String> manualLottos) {
        this.count = new PurchaseCount(calculateCount(new Money(input)));
        this.manualLottos = manualLottos;
    }

    private int calculateCount(Money money) {
        return money.divide(PRICE);
    }

    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();

        generateManual(lottos);
        generateAuto(lottos);

        return lottos;
    }

    private void generateManual(List<Lotto> lottos) {
        for (String manualLotto : manualLottos) {
            lottos.add(new ManualStrategy(manualLotto).generate());
            this.count = count.decrease();
        }
    }

    private void generateAuto(List<Lotto> lottos) {
        while (count.isPositive()) {
            lottos.add(new AutomaticStrategy().generate());
            this.count = count.decrease();
        }
    }
}
