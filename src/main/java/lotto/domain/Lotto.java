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
            if (winningList.get(i).equals(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public String findNumbersForPrint() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}