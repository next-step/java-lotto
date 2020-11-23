package lotto.domain;

import java.util.Set;

public class LottoNumbers {

    private Set<Integer> lottoNumbers;

    public LottoNumbers(Set<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
