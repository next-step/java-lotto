package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BoughtLotto {

    private final List<Lotto> boughtLotto = new ArrayList<>();

    //로또 추가
    public void addLotto(Lotto lotto) {
        this.boughtLotto.add(lotto);
    }

    public List<Lotto> getBoughtLotto() {
        return boughtLotto;
    }
}
