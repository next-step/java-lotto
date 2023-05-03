package lotto;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = LottoFactory.create();
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }
}
