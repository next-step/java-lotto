package lotto.domain;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();

    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
