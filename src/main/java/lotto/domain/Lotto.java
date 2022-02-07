package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<LottoNumber> lottoList;

    public Lotto() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        this.lottoList = lottoNumberGenerator.generate();
    }

    public List<LottoNumber> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

}
