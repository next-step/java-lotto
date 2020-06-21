package edu.nextstep.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int maxNumber = 50;
    private List lotto;
    private int winNumCount;

    Lotto() {
        lotto = new ArrayList();
        this.winNumCount = 0;
    }

    public List makeLotto() {
        for (int i = 1; i <= maxNumber; i++) {
            lotto.add(i);
        }

        Collections.shuffle(lotto);
        return lotto.subList(0, 5);
    }

    public int checkLotto(String[] winNumber) {
        for (int i = 0; i < winNumber.length; i++) {
            if (lotto.contains(Integer.valueOf(winNumber[0]))) {
                this.winNumCount++;
            }
        }

        return this.winNumCount;
    }

}
