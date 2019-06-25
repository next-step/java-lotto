package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private Order order;
    private Lottos lottos;

    public LottoStore(Order order, Lottos handPickLottos) {
        this.lottos = new Lottos();
        this.order = order;
        this.lottos.merge(handPickLottos);
    }

    public Lottos buyAutoPick() {
        for (int i = 0; i < order.getAutoPickCount(); i++) {
            lottos.add(new PickNumbers(NumbersGenerator.autoGenerate()));
        }
        return this.lottos;
    }
}
