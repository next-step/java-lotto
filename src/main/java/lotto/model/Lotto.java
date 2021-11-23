package lotto.model;

import java.util.List;

public class Lotto {

    private final List<LottoNumbers> lotto;

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lotto = lottoNumbers;
    }

    public List<LottoNumbers> getLotto() {
        return lotto;
    }
}
