package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static List<Integer> lottoNumberRange;

    public LottoNumber() {
        lottoNumberRange = new ArrayList<Integer>();
        for (int i = 1; i < 46; i++) {
            lottoNumberRange.add(i);
        }
    }

    public List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<Integer>();
        Collections.shuffle(lottoNumberRange);
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(lottoNumberRange.get(i));
        }
        return lottoNumbers;
    }
}
