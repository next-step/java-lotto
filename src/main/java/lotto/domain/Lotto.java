package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(final LottoNumbers lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumbers.getLottoNumbers();
    }

    public long countMatch(final Lotto lotto){
        return lottoNumbers.countMatch(lotto.lottoNumbers);
    }

    public boolean contains(final LottoNumber lottoNumber){
        return this.lottoNumbers.getLottoNumbers().contains(lottoNumber.value());
    }
}
