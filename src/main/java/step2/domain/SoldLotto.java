package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class SoldLotto {

    private final List<Lotto> soldLotto = new ArrayList<>();

    public SoldLotto(int buyCount) {
        for (int count = 0; count < buyCount; count++) {
            this.soldLotto.add(new Lotto());
        }
    }

    public List<Lotto> getSoldLotto() {
        return soldLotto;
    }
}
