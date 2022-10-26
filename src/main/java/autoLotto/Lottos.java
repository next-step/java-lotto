package autoLotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;
    private int quantity;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
        this.quantity = lottos.size();
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public int getAmount() {
        return this.quantity * LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getQuantity() {
        return quantity;
    }

}
