package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    public static final int PRICE_PER_LOTTO = 1000;
    public static final String MSG_ERR_PRICE_NEGATIVE = "구입 금액은 0원 이상이어야 합니다.";

    private final List<Lotto> lottoBundle = new ArrayList<>();

    public LottoBundle(int money) {
        buy(money);
    }

    private void buy(int money) {
        validateNegative(money);
        for (int i = money / PRICE_PER_LOTTO; i > 0; --i) {
            lottoBundle.add(new Lotto());
        }
    }

    private void validateNegative(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(MSG_ERR_PRICE_NEGATIVE);
        }
    }

    public int count() {
        return lottoBundle.size();
    }
}
