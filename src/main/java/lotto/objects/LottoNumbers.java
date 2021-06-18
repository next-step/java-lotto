package lotto.objects;

import java.util.*;

public class LottoNumbers {
    private static final int LOTTO_MIN_NUMBER = 0;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int NUMBER_COUNT_PER_GAME = 6;

    private List<Integer> allNumbers;

    public LottoNumbers() {
        List<Integer> initNumbers = new ArrayList<>();

        for (int i = LOTTO_MIN_NUMBER; i < LOTTO_MAX_NUMBER; i++) {
            initNumbers.add(i + 1);
        }

        Collections.shuffle(initNumbers);

        this.allNumbers = initNumbers;
    }

    public Lotto getRandomNumbers() {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT_PER_GAME; i++) {
            lotto.add(allNumbers.get(i));
        }

        return new Lotto(new HashSet<>(lotto));
    }
}
