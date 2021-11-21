package lotto.model;

import lotto.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<LottoNumbers> lotto;

    //TEST
    public Lotto(LottoNumbers lottoNumbers) {
        this.lotto = Collections.singletonList(lottoNumbers);
    }

    public Lotto(int count) {
        this.lotto = ticket(count);
    }

    private List<LottoNumbers> ticket(int count) {
        List<LottoNumbers> lotto = new ArrayList<>();
        LottoNumberGenerator generator = new LottoNumberGenerator();
        for (int i = 0; i < count; i++) {
            lotto.add(new LottoNumbers(generator));
        }
        return lotto;
    }

    public List<LottoNumbers> getLotto() {
        return lotto;
    }
}
