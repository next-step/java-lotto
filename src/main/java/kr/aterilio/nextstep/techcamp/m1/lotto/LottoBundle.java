package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoBundle {

    public static final int INTERVAL_COUNT_INCREASE = 1;
    public static final int PRICE_PER_LOTTO = 1000;
    public static final String MSG_ERR_PRICE_NEGATIVE = "구입 금액은 0원 이상이어야 합니다.";

    private final List<Lotto> lottoBundle = new ArrayList<>();

    public LottoBundle(int money) {
        buy(money);
    }

    public LottoBundle(List<Lotto> boughtLotto) {
        this.lottoBundle.addAll(boughtLotto);
    }

    private void buy(int money) {
        validateNegative(money);
        for (int i = money / PRICE_PER_LOTTO; i > 0; --i) {
            lottoBundle.add(new Lotto(Machine.draw()));
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

    public Map<Integer, Integer> matchCounts(LuckyNumbers luckyNumbers) {
        Map<Integer, Integer> result = new HashMap<>();
        for(Lotto lotto : lottoBundle) {
            result.merge(luckyNumbers.matchCount(lotto), INTERVAL_COUNT_INCREASE, Integer::sum);
        }
        return result;
    }
}
