package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoGenerator;
import lotto.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class FakeLotto implements LottoGenerator {
    public final List<LottoNumber> lottoNumbers;

    public FakeLotto() {
        this.lottoNumbers = new ArrayList<>();
    }

    public FakeLotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    @Override
    public Lotto generateLotto() {
        List<LottoNumber> newLottoNumbers = new ArrayList<>();
        newLottoNumbers.add(new LottoNumber(1));
        newLottoNumbers.add(new LottoNumber(2));
        newLottoNumbers.add(new LottoNumber(3));
        newLottoNumbers.add(new LottoNumber(4));
        newLottoNumbers.add(new LottoNumber(5));
        newLottoNumbers.add(new LottoNumber(10));
        return new Lotto(newLottoNumbers);
    }

    @Override
    public List<LottoNumber> getLotto() {
        return lottoNumbers;
    }
}
