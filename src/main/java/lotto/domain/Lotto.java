package lotto.domain;

import lotto.common.LottoNumbersMaker;

import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers;
    
    public Lotto() {
        this.lottoNumbers = LottoNumbersMaker.getNewLottoNumbers();
    }
    
    public boolean checkNumberRange() {
        return lottoNumbers.stream().allMatch(LottoNumber::isInNumberRange);
    }
    
    public boolean checkDuplicateNumber() {
        return lottoNumbers.stream()
          .distinct()
          .count() != lottoNumbers.size();
    }
    
    @Override
    public String toString() {
        return lottoNumbers + "\n";
    }
}
