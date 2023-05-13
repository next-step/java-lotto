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
}
