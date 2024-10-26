package lotto.entity;

import java.util.ArrayList;
import java.util.List;

public class AllLottoNumbers {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public AllLottoNumbers() {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            this.lottoNumbers.add(new LottoNumber(i));
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
