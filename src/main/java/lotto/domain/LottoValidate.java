package lotto.domain;

import lotto.domain.matchcase.Case;
import lotto.domain.matchcase.RankMatcher;

import java.util.List;
import java.util.Map;

public class LottoValidate {
    private static final int REFERENCE_PRICE = 1000;
    private static final int REMAINDER_VALUE = 10;

    private int count = 0;

    public int priceValidation(int price) {
        if (price % REMAINDER_VALUE != 0) {
            throw new IllegalArgumentException("천원 단위로 입력해야 합니다.");
        }

        if (price < REFERENCE_PRICE) {
            throw new IllegalArgumentException("돈이 천원보다 작습니다.");
        }
        return lottoCount(price);
    }

    private int lottoCount(int price) {
        return (int) Math.floor(price / REFERENCE_PRICE);
    }

    public void correctCheck(Lotto lotto, List<Integer> correctNumbers, int bonusNumber) {
        count = 0;
        List<Integer> list = lotto.getLotto();
        for(int i = 0 ; i < correctNumbers.size(); i++) {
            getCorrectCount(list, correctNumbers, i);
        }

        bonusCheck(lotto, bonusNumber);
    }

    private void bonusCheck(Lotto lotto, int bonusNumber) {
        RankMatcher.gradeMatcher(count, bonusNumCheck(lotto.getLotto(), bonusNumber));
    }

    private void getCorrectCount(List<Integer> list, List<Integer> correctNumbers, int index) {
        if (list.contains(correctNumbers.get(index))) {
            count++;
        }
    }

    private boolean bonusNumCheck(List<Integer> list, int bonusNumber) {
        if (list.contains(bonusNumber)) {
            count++;
            return true;
        }

        return false;
    }

    public Map<String, Integer> lotteryRewards() {
        return Case.lotteryRewards();
    }
}
