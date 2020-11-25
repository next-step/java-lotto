package step2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final List<Integer> TOTAL_NUMBERS = Arrays.asList(
            1,2,3,4,5,6,7,8,9,10,
            11,12,13,14,15,16,17,18,19,20,
            21,22,23,24,25,26,27,28,29,30,
            31,32,33,34,35,36,37,38,39,40,
            41,42,43,44,45);

    public List<Integer> getLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(this.TOTAL_NUMBERS);
        Collections.shuffle(lottoNumbers);
        List<Integer> extractionLottoNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(extractionLottoNumbers);
        return extractionLottoNumbers;
    }
}
