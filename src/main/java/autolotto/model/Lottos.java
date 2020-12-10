package autolotto.model;

import autolotto.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(Money money) {

        for (int i = 0; i < money.getBuyableLotto(); i++) {
            lottos.add(new Lotto());
        }
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }
}
