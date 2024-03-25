package domain;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

    private static List<Lotto> lotto;

    public MyLotto() {
        lotto = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        MyLotto.lotto.add(lotto);
    }

    public static List<Lotto> getLotto() {
        return lotto;
    }
}
