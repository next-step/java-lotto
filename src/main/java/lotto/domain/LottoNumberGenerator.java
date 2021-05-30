package lotto.domain;

import lotto.common.Constant;

import java.util.*;

public class LottoNumberGenerator implements LottoNumberGeneratorStrategy {
    private static List<Integer> lottoNumberRange;

    public LottoNumberGenerator() {
        lottoNumberRange = new ArrayList<Integer>();
        for (int i = 1; i <= Constant.MAX_LOTTO_NUMBER.value(); i++) {
            lottoNumberRange.add(i);
        }
    }

    public List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<Integer>();
        Collections.shuffle(lottoNumberRange);
        for (int i = 0; i < Constant.LOTTO_NUMBER_COUNT.value(); i++) {
            lottoNumbers.add(lottoNumberRange.get(i));
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
