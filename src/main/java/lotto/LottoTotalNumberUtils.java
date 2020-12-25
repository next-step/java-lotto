package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTotalNumberUtils {

    private static final List<Number> lottoTotalNumbers = new ArrayList<>();

    static {
        for (int i = Number.LOTTO_NUMBER_MINIMUM; i <= Number.LOTTO_NUMBER_MAXIMUM; i++) {
            lottoTotalNumbers.add(Number.newNumber(i));
        }
    }

    public static List<Number> getLottoTotalNumbers() {
        List<Number> newLottoTotalNumbers = new ArrayList<>(lottoTotalNumbers);
        Collections.shuffle(newLottoTotalNumbers);

        return newLottoTotalNumbers;
    }
}
