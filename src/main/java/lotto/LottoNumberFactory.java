package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberFactory {

    private final List<Integer> randomNumbers;

    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private LottoNumberFactory() {
        randomNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            randomNumbers.add(i);
        }
    }

    public static LottoNumberFactory getInstance() {
        return RandomHolder.INSTANCE;
    }

    public List<Integer> number() {
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(0, LOTTO_NUMBER_COUNT);
    }

    private static class RandomHolder {

        private static final LottoNumberFactory INSTANCE = new LottoNumberFactory();
    }
}
