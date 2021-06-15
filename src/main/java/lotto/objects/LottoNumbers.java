package lotto.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_MIN_NUMBER = 0;
    private static final int LOTTO_MAX_NUMBER = 45;

    private List<Integer> allNumbers;

    public LottoNumbers() {
        List<Integer> initNumbers = new ArrayList<>();

        for (int i = LOTTO_MIN_NUMBER; i < LOTTO_MAX_NUMBER; i++) {
            initNumbers.add(i + 1);
        }

        this.allNumbers = initNumbers;
    }

    public List<Integer> getRandomNumbers() {
        Collections.shuffle(allNumbers);

        return allNumbers;
    }
}
