package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTotalNumberUtils {

    private static final List<Number> lottoTotalNumbers = new ArrayList<>();
    public static final int LOTTO_NUMBER_MINIMUM = 1;
    public static final int LOTTO_NUMBER_MAXIMUM = 45;

    static {
        for (int i = LOTTO_NUMBER_MINIMUM; i <= LOTTO_NUMBER_MAXIMUM; i++) {
            lottoTotalNumbers.add(Number.newNumber(i));
        }
    }

    public static List<Number> getLottoTotalNumbers() {
        List<Number> newLottoTotalNumbers = new ArrayList<>(lottoTotalNumbers);
        Collections.shuffle(newLottoTotalNumbers);

        return newLottoTotalNumbers;
    }
}
