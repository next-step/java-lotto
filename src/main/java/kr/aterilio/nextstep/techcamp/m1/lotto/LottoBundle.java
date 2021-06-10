package kr.aterilio.nextstep.techcamp.m1.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoBundle {

    private static final int INTERVAL_COUNT_INCREASE = 1;
    private static final String MSG_ERR_PRICE_NEGATIVE = "구입 금액은 0원 이상이어야 합니다.";
    private static final String LINE_SEPARATOR = "\n";

    private final List<Lotto> lottoBundle = new ArrayList<>();

    public LottoBundle(int money) {
        buy(money);
    }

    public LottoBundle(List<Lotto> boughtLotto) {
        this.lottoBundle.addAll(boughtLotto);
    }

    private void buy(int money) {
        validateNegative(money);
        for (int i = money / Lotto.PRICE_PER_LOTTO; i > 0; --i) {
            lottoBundle.add(Machine.draw());
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

    public Map<ResultRank, Integer> matchCounts(LuckyNumbers luckyNumbers) {
        Map<ResultRank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottoBundle) {
            result.merge(luckyNumbers.rank(lotto), INTERVAL_COUNT_INCREASE, Integer::sum);
        }
        return result;
    }

    public int paid() {
        return lottoBundle.size() * Lotto.PRICE_PER_LOTTO;
    }

    public String join() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoBundle) {
            sb.append(lotto.join()).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

    public boolean empty() {
        return lottoBundle.isEmpty();
    }
}
