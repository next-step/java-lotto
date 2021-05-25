package lotto;

import java.util.*;

public class LottoNumberGenerator implements LottoNumberGeneratorStrategy {
    private static List<Integer> lottoNumberRange;

    public LottoNumberGenerator() {
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
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
