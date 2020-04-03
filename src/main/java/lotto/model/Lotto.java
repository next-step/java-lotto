package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lotto) {
        this.lottoNumbers = Collections.unmodifiableList(lotto);
    }
}
