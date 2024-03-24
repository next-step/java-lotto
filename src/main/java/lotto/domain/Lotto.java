package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    public Lotto(List<Integer> lottoNumbers) {
        this.lotto = LottoGenerator.createLotto(lottoNumbers);
    }

    public Lotto() {
        this.lotto = LottoGenerator.createLotto(LottoGenerator.shuffleNumbers());
    }

    public List<LottoNumber> getLotto() {
        return this.lotto;
    }
}
