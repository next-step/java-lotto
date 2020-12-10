package autolotto.model;

import autolotto.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int money) {
        if (money < 1000) {
            throw new NotEnoughMoneyException("1000원보다 작은 돈으로는 복권을 살 수 없습니다.");
        }

        for (int i = 0; i < (money / 1000); i++) {
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
