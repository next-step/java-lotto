package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_SIZE = 6;

    public List<Integer> generate(List<Integer> basicNumbers) {
        Collections.shuffle(basicNumbers);
        List<Integer> shuffledNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            shuffledNumbers.add(basicNumbers.get(i));
        }
        return sort(shuffledNumbers);
    }

    private List<Integer> sort(List<Integer> shuffledNumbers) {
        Collections.sort(shuffledNumbers);
        return shuffledNumbers;
    }
}
