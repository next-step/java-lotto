package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final Numbers numbers;

    public Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Lotto autoGenerate() {
        List<Integer> autoNumbers = new ArrayList<>(LottoRule.NUMBER_RANGE);
        Collections.shuffle(autoNumbers);
        autoNumbers = autoNumbers.subList(0, LottoRule.CHOICE_COUNT);
        Collections.sort(autoNumbers);
        return new Lotto(new Numbers(autoNumbers));
    }

    public Numbers numbers() {
        return numbers;
    }

    public int checkMatchingNumbers(WinLotto winLotto) {
        int result = 0;
        for (int i = 0; i < LottoRule.CHOICE_COUNT; i++) {
            result += checkMatchingNumber(winLotto.findNumber(i));
        }
       return result;
    }

    private int checkMatchingNumber(Integer winNumber) {
        if (numbers.contains(winNumber)) {
            return 1;
        }
        return 0;
    }
}
