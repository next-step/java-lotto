package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final List<Integer> totalNumbers = new ArrayList<>();

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int MAX_SIZE = 6;
    private static final int START = 0;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            totalNumbers.add(i);
        }
    }

    public List<Integer> getRandomLottoNumber() {
        Collections.shuffle(totalNumbers);

        return totalNumbers.subList(START, MAX_SIZE);
    }
}
