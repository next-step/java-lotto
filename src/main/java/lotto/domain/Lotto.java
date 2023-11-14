package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(NumberGeneration numberGeneration) {
        this.numbers = makeLotto(numberGeneration);
    }

    public static List<Integer> makeLotto(NumberGeneration numberGeneration) {
        return numberGeneration.generate();
    }

    public int countMatchNumber(List<Integer> winningList) {
        int count = 0;
        for (int i = 0; i < COUNT; i++) {
            count += checkMatch(winningList.get(i));
        }
        return count;
    }

    private int checkMatch( int matchNumber) {
        if (numbers.contains(matchNumber)) {
            return 1;
        }
        return 0;
    }

    public String findNumbersExtract() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}