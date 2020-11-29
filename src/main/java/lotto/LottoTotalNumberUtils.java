package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTotalNumberUtils {

    private static final List<Integer> lottoTotalNumbers = new ArrayList<>();
    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;

    static {
        for (int i = LOTTO_NUMBER_MINIMUM; i <= LOTTO_NUMBER_MAXIMUM; i++) {
            lottoTotalNumbers.add(i);
        }
    }

    public static List<Integer> getLottoTotalNumbers() {
        List<Integer> newLottoTotalNumbers = new ArrayList<>(lottoTotalNumbers);
        Collections.shuffle(newLottoTotalNumbers);

        return newLottoTotalNumbers;
    }
}
