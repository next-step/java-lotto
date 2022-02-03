package lotto.domain;

import java.util.List;

public class Lotto {
    private final LottoFullNumber lottoNumber;
    public Lotto(LottoFullNumber lottoNumber){
        this.lottoNumber = lottoNumber;
    }

    public LottoFullNumber getLottoNumber() {
        return lottoNumber;
    }
}
