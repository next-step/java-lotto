package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<LottoNumber> lottoList;

    public Lotto(List<LottoNumber> lottoList) {
        this.lottoList = lottoList;
    }

    public List<LottoNumber> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

}
