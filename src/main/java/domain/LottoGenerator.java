package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGenerator {
    private static final List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>(LottoNumber.LOTTO_MAX_NUMBER);

        for (int i = LottoNumber.LOTTO_MIN_NUMBER; i <= LottoNumber.LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(LottoNumber.of(i));
        }
    }

    public static LottoSet getLottoSet() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> selectLottoNumbers = new ArrayList<>(lottoNumbers.subList(0, LottoSet.LOTTO_SIZE));
        return new LottoSet(selectLottoNumbers);
    }
}