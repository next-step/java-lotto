package lottoAuto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MINIMUM_LOTTO_NUMBER = 1;

    public static List<Integer> lottoNumbers = new ArrayList<>();

    static {
        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }
    }
}
