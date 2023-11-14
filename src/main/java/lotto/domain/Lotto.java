package lotto.domain;

import calculator.domain.NumberGeneration;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(NumberGeneration numberGeneration) {
        this.lotto = numberGeneration.generate();
    }
    public List<Integer> find() {
        return Collections.unmodifiableList(lotto);
    }

    public int countMath(List<Integer> winList) {
        winList.retainAll(lotto);
        return winList.size();
    }

    public boolean isHaveBonus(int bonus) {
        return lotto.contains(bonus);
    }

    public boolean isRank(List<Integer> winList){
        winList.retainAll(lotto);
        return winList.size()>2;
    }
}
