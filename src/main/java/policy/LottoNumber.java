package policy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoNumber {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT_LIMIT = 6;

    private LottoNumber() {
    }

    public static List<Integer> generateLottoNumber() {
        List<Integer> allNumbers = new ArrayList<>();

        for (int i = 1; i <= MAX_LOTTO_NUMBER; i++) {
            allNumbers.add(i);
        }

        Collections.shuffle(allNumbers);
        List<Integer> lottoNumbers = allNumbers.subList(0, LOTTO_NUMBER_COUNT_LIMIT);

        return lottoNumbers;
    }
}
