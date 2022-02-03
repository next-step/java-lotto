package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFullNumber {

    private final List<LottoNumber> lottoFullNumber;

    public LottoFullNumber(List<LottoNumber> lottoFullNumber) {
        List<LottoNumber> lottoFullNumberLengthSix = lottoFullNumber.subList(0,6);
        Collections.sort(lottoFullNumberLengthSix);
        this.lottoFullNumber = new ArrayList<>(lottoFullNumberLengthSix);
    }

    public List<LottoNumber> getLottoFullNumber() {
        return lottoFullNumber;
    }
}
