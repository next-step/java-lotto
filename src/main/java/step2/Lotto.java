package step2;

import java.util.List;

public class Lotto {

    protected final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    protected int match(LottoNumbers winningLottoNumbers) {
        return winningLottoNumbers.countNumberOfMatch(this.lottoNumbers);
    }
}
