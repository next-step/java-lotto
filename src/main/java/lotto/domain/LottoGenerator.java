package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final Lotto lotto;

    public LottoGenerator() {
        lotto = Lotto.from(new ArrayList<Integer>(generatorLotto()));
    }

    public static LottoGenerator of() {
        return new LottoGenerator();
    }

    public Lotto getLotto() {
        return lotto;
    }

    private HashSet<Integer> generatorLotto() {
        HashSet<Integer> lotto = new HashSet<>();

        while (lotto.size() < LOTTO_SIZE) {
            lotto.add(generateNumber(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }

        return lotto;
    }

    private int generateNumber(int min, int max) {
        return new Random().nextInt(max) + min;
    }
}
