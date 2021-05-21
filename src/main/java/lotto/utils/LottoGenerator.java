package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGenerator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    private static final List<LottoNumber> NUMBER_BOX = new ArrayList<>(MAX_NUMBER);

    static {
        for (int i = MIN_NUMBER; i < MAX_NUMBER; i++) {
            NUMBER_BOX.add(new LottoNumber(i));
        }
    }

    private LottoGenerator() {
    }

    public static List<LottoNumber> drawLots() {
        Collections.shuffle(NUMBER_BOX);
        return NUMBER_BOX.subList(0, LOTTO_SIZE);
    }
}
