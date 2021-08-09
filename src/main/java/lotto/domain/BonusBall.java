package lotto.domain;

import java.util.List;

public class BonusBall {

    private final LottoNumber lottoNumber;

    public BonusBall(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public boolean contains(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(lottoNumber);
    }

}
