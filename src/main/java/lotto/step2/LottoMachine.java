package lotto.step2;

import java.util.ArrayList;
import java.util.Collections;

public class LottoMachine {
    private static ArrayList<Integer> lottoNumbers = new ArrayList<>();
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_LAST_COUNT = 6;

    static {
        for (int i = 1; i <= LOTTO_LAST_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }

    public static void mixLottoNumbers() {
        Collections.shuffle(lottoNumbers);
    }
}
