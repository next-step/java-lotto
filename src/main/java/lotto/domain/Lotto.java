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
        List<Integer> autoNumbers = new ArrayList<>(Numbers.NUMBER_RANGE);
        Collections.shuffle(autoNumbers);
        autoNumbers = autoNumbers.subList(0, Numbers.CHOICE_COUNT);
        Collections.sort(autoNumbers);
        return new Lotto(new Numbers(autoNumbers));
    }

    public Numbers numbers() {
        return numbers;
    }

    public Rank checkMatchingNumbers(WinLotto winLotto) {
        int matchCount = 0;
        for (int i = 0; i < Numbers.CHOICE_COUNT; i++) {
            matchCount += checkMatchingNumber(winLotto.findNumber(i));
        }
        boolean matchBounus = (1 == checkMatchingNumber(winLotto.bonusNumber()));
        return Rank.of(matchCount, matchBounus);
    }

    private int checkMatchingNumber(Integer winNumber) {
        if (numbers.contains(winNumber)) {
            return 1;
        }
        return 0;
    }
}
