package lotto.auto.domain;

import java.util.Collections;
import java.util.List;

public class FullNumber {

    private LottoNumber lottoNumber;

    public List<Integer> getFullNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        Collections.shuffle(lottoNumber.getLottoNumber());
        return lottoNumber.getLottoNumber();
    }
}
