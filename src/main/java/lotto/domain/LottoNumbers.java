package lotto.domain;

import lotto.common.ErrorMessage;
import lotto.common.LottoNumbersMaker;

import java.util.List;

public class LottoNumbers {
    private final static int LOTTO_NUMBER_COUNT = 6;
    
    private List<LottoNumber> lottoNumbers;
    
    LottoNumbers() {
        this.lottoNumbers = LottoNumbersMaker.getNewLottoNumbers();
    }
    
    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
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
    
    public int getMatchedNumberCount(final LottoNumbers lottoNumbers) { 
        return this.lottoNumbers.stream()
            .filter(lottoNumbers::contains)
            .mapToInt(lottoNumber -> 1)
            .sum();
    }
    
    private boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
    
    @Override
    public String toString() {
        return "\n(" + lottoNumbers + ")";
    }
    
    public boolean haveBonusNumber(BonusNumber bonusNumber) {
        LottoNumber bonusLottoNumber = bonusNumber.getLottoNumber();
        return lottoNumbers.contains(bonusLottoNumber);
    }
}
