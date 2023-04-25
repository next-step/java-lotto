package lotto.utils;

import lotto.domain.AllNumbers;
import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private static final int NUMBER_PICK_FIRST_ORDER = 1;
    private static final int NUMBER_PICK_LAST_ORDER = 6;

    public static LottoNumbers generateLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = NUMBER_PICK_FIRST_ORDER; i <= NUMBER_PICK_LAST_ORDER; i++) {
            lottoNumbers.add(shuffledNumbers().get(i));
        }
        return new LottoNumbers(lottoNumbers);
    }

    private static List<Integer> shuffledNumbers() {
        List<Integer> allLottoNumbers = AllNumbers.value();
        Collections.shuffle(allLottoNumbers);
        return allLottoNumbers;
    }
}
