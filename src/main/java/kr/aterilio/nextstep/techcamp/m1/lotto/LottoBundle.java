package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    public static final int PRICE_PER_LOTTO = 1000;

    private final List<Lotto> lottoBundle = new ArrayList<>();

    public LottoBundle(int money) {
        buy(money);
    }

    private void buy(int money) {
        for (int i = money / PRICE_PER_LOTTO; i > 0; --i) {
            lottoBundle.add(new Lotto());
        }
    }

    public int count() {
        return lottoBundle.size();
    }
}
