package lotto.model;

import lotto.factory.LottoNumbersFactory;
import lotto.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<LottoNumbers> lotto;

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lotto = lottoNumbers;
    }

    public Lotto(int count) {
        this.lotto = autoCreateLotto(count);
    }

    private List<LottoNumbers> autoCreateLotto(int count) {
        List<LottoNumbers> lotto = new ArrayList<>();
        LottoNumberGenerator generator = new LottoNumberGenerator();
        for (int i = 0; i < count; i++) {
            lotto.add(LottoNumbersFactory.autoCreateNumbers(generator));
        }
        return lotto;
    }

    public List<LottoNumbers> getLotto() {
        return lotto;
    }
}
