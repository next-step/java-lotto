package lotto.domain;

import lotto.constants.Const;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> autoLotto;

    public Lotto() {
        List<Integer> shuffleNumbers = new ArrayList<>(Const.NUMBER_LIST);
        Collections.shuffle(shuffleNumbers);
        this.autoLotto = shuffleNumbers.subList(0, 6);
    }

    public List<Integer> getAutoLotto() {
        return autoLotto;
    }
}
