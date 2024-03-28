package lotto.domain;

import lotto.constants.Const;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> autoLotto;
    private int matchingCount;

    public Lotto() {
        List<Integer> shuffleNumbers = new ArrayList<>(Const.NUMBER_LIST);
        Collections.shuffle(shuffleNumbers);
        this.autoLotto = shuffleNumbers.subList(0, 6);
        this.matchingCount = 0;
    }

    public Lotto(List<Integer> autoLotto) {
        this.autoLotto = autoLotto;
        this.matchingCount = 0;
    }

    public List<Integer> getAutoLotto() {
        return autoLotto;
    }

    public int getMatchingCount(List<Integer> winNo) {
        return updateMatchingCount(winNo);
    }

    public int updateMatchingCount(List<Integer> winNo) {
        matchingCount = (int) autoLotto.stream()
                .filter(winNo::contains)
                .count();
        return matchingCount;
    }
}
