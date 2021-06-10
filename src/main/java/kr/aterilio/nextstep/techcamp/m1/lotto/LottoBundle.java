package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.lotto.result.ResultRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoBundle {

    private static final int INTERVAL_COUNT_INCREASE = 1;

    private static final String LINE_SEPARATOR = "\n";
    private static final String MSG_ERR_PRICE_NEGATIVE = "구입 금액은 0원 이상이어야 합니다.";
    private static final String MSG_ERR_INSUFFICIENCY_MONEY = "구매할 금액이 충분하지 않습니다.";
    private static final String MSG_ERR_INSUFFICIENCY_MANUAL_COUNT = "입력하신 수동 구매 횟수와 로또 갯수가 일치하지 않습니다.";

    private final List<Lotto> lottoBundle = new ArrayList<>();

    public LottoBundle(int money) {
        buy(money);
    }

    public LottoBundle(int money, int manualCount, List<Lotto> boughtLotto) {
        validateSufficiencyMoney(money, boughtLotto.size());
        validateSufficiencyManualCount(manualCount, boughtLotto.size());
        buyManual(boughtLotto);
        buy(remains(money, manualCount));
    }

    private void buyManual(List<Lotto> boughtLotto) {
        lottoBundle.addAll(boughtLotto);
    }

    private int remains(int money, int manualCount) {
        return money - (manualCount * Lotto.PRICE_PER_LOTTO);
    }

    private void validateSufficiencyManualCount(int manualCount, int inputCount) {
        if (manualCount != inputCount) {
            throw new IllegalArgumentException(MSG_ERR_INSUFFICIENCY_MANUAL_COUNT);
        }
    }

    private void validateSufficiencyMoney(int money, int manualCount) {
        if (!buyable(money, manualCount)) {
            throw new IllegalArgumentException(MSG_ERR_INSUFFICIENCY_MONEY);
        }
    }

    private boolean buyable(int money, int manualCount) {
        return manualCount * Lotto.PRICE_PER_LOTTO <= money;
    }

    public LottoBundle(List<Lotto> boughtLotto) {
        buyManual(boughtLotto);
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
