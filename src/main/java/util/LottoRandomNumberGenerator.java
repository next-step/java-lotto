package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomNumberGenerator {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBER_COUNT_LIMIT = 6;

    private static List<Integer> allNumbers;

    static {
        initialize();
    }

    private LottoRandomNumberGenerator() {
    }

    private static void initialize() {
        allNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            allNumbers.add(i);
        }
    }

    public static List<Integer> generateLottoNumber() {
        Collections.shuffle(allNumbers);

        List<Integer> lottoNumbers = allNumbers.subList(0, LOTTO_NUMBER_COUNT_LIMIT);
        return lottoNumbers;
    }
}
