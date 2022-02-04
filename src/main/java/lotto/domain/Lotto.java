package lotto.domain;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumber;

    public Lotto(final LottoNumbers lottoNumber){
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber.getLottoFullNumber();
    }

    public long countMatch(final Lotto lotto){
        return lottoNumber.countMatch(lotto.lottoNumber);
    }

    public boolean contains(final LottoNumber lottoNumber){
        return this.lottoNumber.getLottoFullNumber().contains(lottoNumber.value());
    }
}
