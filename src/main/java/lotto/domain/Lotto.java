package lotto.domain;

import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoNumbers> lotto;

    public Lotto() {
        this.lotto = new ArrayList<>();
    }

    public List<LottoNumbers> lotto() {
        return lotto;
    }

    public void buy(int count) {
        for (int i = 0; i < count; i++) {
            lotto.add(new LottoNumbers());
        }
        for (LottoNumbers lottoNumbers : lotto) {
            lottoNumbers.mark();
        }
    }
}
