package lotto.domain;

import lotto.common.Constant;
import lotto.common.LottoNoComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator implements LottoNumberGeneratorStrategy {
    private static List<LottoNo> lottoNumberRange;

    public LottoNumberGenerator() {
        lottoNumberRange = new ArrayList<LottoNo>();
        for (int i = 1; i <= Constant.MAX_LOTTO_NUMBER.value(); i++) {
            lottoNumberRange.add(new LottoNo(i));
        }
    }

    public List<LottoNo> generateLottoNumber() {
        List<LottoNo> lottoNumbers = new ArrayList<LottoNo>();
        Collections.shuffle(lottoNumberRange);
        for (int i = 0; i < Constant.LOTTO_NUMBER_COUNT.value(); i++) {
            lottoNumbers.add(lottoNumberRange.get(i));
        }
        LottoNoComparator comp = new LottoNoComparator();
        Collections.sort(lottoNumbers, comp);
        return lottoNumbers;
    }
}
