package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (isNotEqualLottoNumbersSize(lottoNumbers)) {
            throw new IllegalArgumentException("로또번호 개수가 부족하거나 초과하였습니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }

    private boolean isNotEqualLottoNumbersSize(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != LOTTO_NUMBERS_COUNT;
    }
}
