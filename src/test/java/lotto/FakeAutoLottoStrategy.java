package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoGeneratorStrategy;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoParameters;
import lotto.lotto.Lottos;

import java.util.ArrayList;
import java.util.List;

public class FakeAutoLottoStrategy implements LottoGeneratorStrategy {
    public List<Lotto> lottos = new ArrayList<>();

    public FakeAutoLottoStrategy() {
    }

    @Override
    public Lottos generateLotto(LottoParameters lottoParameters) {
        List<LottoNumber> newLottoNumbers = new ArrayList<>();
        for(int i = 0; i < lottoParameters.getAutoCount(); i++) {
            newLottoNumbers.add(new LottoNumber(1));
            newLottoNumbers.add(new LottoNumber(2));
            newLottoNumbers.add(new LottoNumber(3));
            newLottoNumbers.add(new LottoNumber(4));
            newLottoNumbers.add(new LottoNumber(5));
            newLottoNumbers.add(new LottoNumber(10));
            lottos.add(new Lotto(newLottoNumbers));
        }
        return new Lottos(lottos);
    }

    public Lottos getLotto() {
        return new Lottos(lottos);
    }
}
