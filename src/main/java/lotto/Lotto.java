package lotto;

import java.util.Iterator;
import java.util.List;

public class Lotto implements Iterable<LottoNumber> {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> inputLottoNumbers) {
        this.lottoNumbers = inputLottoNumbers;
    }

    public Lotto(String inputNumbers) {
        this.lottoNumbers = LottoFactory.createLotto(inputNumbers);
    }


    public List<LottoNumber> lottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return this.lottoNumbers.iterator();
    }
}
