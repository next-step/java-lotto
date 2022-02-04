package lotto.domain;

import java.util.List;

public class Lotto {
    private final LottoFullNumber lottoNumber;
    public Lotto(LottoFullNumber lottoNumber){
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber.getLottoFullNumber();
    }
}
