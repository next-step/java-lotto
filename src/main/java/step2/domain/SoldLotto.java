package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoldLotto {

    private final List<Lotto> soldLotto = new ArrayList<>();

    public SoldLotto(int buyCount) {
        for (int count = 0; count < buyCount; count++) {
            this.soldLotto.add(new Lotto());
        }
    }

    public SoldLotto(Lotto lotto) {
        this.soldLotto.add(lotto);
    }

    public static SoldLotto of(int autoCount, List<List<Integer>> notAutoNumbers) {
        SoldLotto soldLotto = new SoldLotto(autoCount);
        for (List<Integer> notAutoNumber : notAutoNumbers) {
            soldLotto.addSoldLotto(notAutoNumber);
        }
        return soldLotto;
    }

    private void addSoldLotto(List<Integer> notAutoNumber) {
        this.soldLotto.add(Lotto.create(notAutoNumber));
    }

    public List<Lotto> getSoldLotto() {
        return Collections.unmodifiableList(soldLotto);
    }
}
