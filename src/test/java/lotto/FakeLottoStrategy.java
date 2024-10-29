package lotto;

import lotto.lotto.*;
import lotto.lotto.LottoParameters;

import java.util.ArrayList;
import java.util.List;

public class FakeLottoStrategy implements LottoGeneratorStrategy {
    public final List<LottoNumber> lottoNumbers;

    public FakeLottoStrategy() {
        this.lottoNumbers = new ArrayList<>();
    }

    public FakeLottoStrategy(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    @Override
    public Lottos generateLotto(LottoParameters lottoParameters) {
        List<LottoNumber> newLottoNumbers = new ArrayList<>();
        newLottoNumbers.add(new LottoNumber(1));
        newLottoNumbers.add(new LottoNumber(2));
        newLottoNumbers.add(new LottoNumber(3));
        newLottoNumbers.add(new LottoNumber(4));
        newLottoNumbers.add(new LottoNumber(5));
        newLottoNumbers.add(new LottoNumber(10));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(newLottoNumbers));
        return new Lottos(lottos);
    }

    public List<LottoNumber> getLotto() {
        return lottoNumbers;
    }
}
