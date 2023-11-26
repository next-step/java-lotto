package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private static List<Integer> allNumbers;
    public static final Integer MIN_LOTTO_NUMBER = Integer.valueOf(1);
    public static final Integer MAX_LOTTO_NUMBER = Integer.valueOf(45);
    public static final Integer LOTTO_NUMBER_COUNT_LIMIT = Integer.valueOf(6);

    static {
        initialize();
    }

    private LottoNumberGenerator() {
    }

    private static void initialize() {
        allNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            allNumbers.add(i);
        }
    }

    public static List<Integer> generateLottoNumber() {
        Collections.shuffle(allNumbers);

        return allNumbers.subList(0, LOTTO_NUMBER_COUNT_LIMIT);
    }
}
