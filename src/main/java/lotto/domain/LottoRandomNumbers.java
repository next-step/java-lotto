package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomNumbers {

    private static final int BOUND = 45;

    private List<Integer> allNumbers;

    public LottoRandomNumbers() {
        allNumbers = new ArrayList<>();
        for (int i = 1; i <= BOUND; i++) {
            allNumbers.add(i);
        }
    }

    public int generateRandomNumbers() {
        Collections.shuffle(allNumbers);
        return allNumbers.get(0);
    }


}
