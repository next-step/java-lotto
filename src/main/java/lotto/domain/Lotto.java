package lotto.domain;

import lotto.common.ErrorMessage;
import lotto.common.LottoNumbersMaker;

import java.util.List;

public class Lotto {
    private final static int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> lottoNumbers;
    
    public Lotto() {
        this.lottoNumbers = LottoNumbersMaker.getNewLottoNumbers();
    }
    
    public Lotto(List<LottoNumber> lottoNumbers) {
        if (!checkDuplicateNumber(lottoNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.message());
        }
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_ERROR.message());
        }
        this.lottoNumbers = lottoNumbers;
    }

    private static boolean checkDuplicateNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
          .distinct()
          .count() == lottoNumbers.size();
    }
    
    @Override
    public String toString() {
        return "\n(" + lottoNumbers + ")";
    }
}
