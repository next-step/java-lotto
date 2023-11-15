package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(NumberGeneration numberGeneration) {
        this.lotto = numberGeneration.generate();
    }

    public Lotto(List<Integer> list) {
        this.lotto = list;
    }

    public List<Integer> find() {
        return Collections.unmodifiableList(lotto);
    }


    public LottoRank findRank(List<Integer> winList, int bonus) {
        if (isRank(winList)) {
            return LottoRank.findMatchCount(countMath(winList), isHaveBonus(bonus));
        }
        return LottoRank.MISS;

    }

    boolean isHaveBonus(int bonus) {
        return lotto.contains(bonus);
    }

    private boolean isRank(List<Integer> winList) {
        return countMath(winList) > 2;
    }

    int countMath(List<Integer> winList) {
        int count = 0;
        for (int i = 0; i < lotto.size(); i++) {
            count += Collections.frequency(winList, lotto.get(i));
        }
        return count;
    }
}
