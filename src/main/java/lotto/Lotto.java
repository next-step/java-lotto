package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    private LottoNumbers lottoNumber;

    public Lotto(LottoNumbers lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public LottoNumbers getLottoNumber() {
        return lottoNumber;
    }

}
